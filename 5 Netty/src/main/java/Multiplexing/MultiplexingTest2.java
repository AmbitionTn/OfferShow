package Multiplexing;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiplexingTest2 {
    private ServerSocketChannel server = null;
    private Selector selector1;
    private Selector selector2;
    private Selector selector3;
    private boolean boss = false;
    int PORT = 9000;

    /**
     * 初始化Server服务器
     */
    public void initServer() {
        try {
            server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.bind(new InetSocketAddress(PORT));

            selector1 = Selector.open();
            selector2 = Selector.open();
            selector3 = Selector.open();
            server.register(selector1, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MultiplexingTest2 service = new MultiplexingTest2();
        service.initServer();
        NioThread nioThread1 = new NioThread(service.selector1, 2);
        NioThread nioThread2 = new NioThread(service.selector2);
        NioThread nioThread3 = new NioThread(service.selector3);

        nioThread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nioThread2.start();
        nioThread3.start();
    }

    static class NioThread extends Thread {
        Selector selector = null;
        static int selectors = 0;
        int id = 0;
        static BlockingQueue<SocketChannel>[] queues;
        static AtomicInteger ids = new AtomicInteger();
        boolean boss = false;

        NioThread(Selector sel, int n) {
            this.selector = sel;
            this.selectors = n;
            queues = new LinkedBlockingQueue[selectors];
            for (int i = 0; i < n; i++) {
                queues[i] = new LinkedBlockingQueue<>();
            }
            boss = true;
            System.out.println("Boss 启动");
        }

        NioThread(Selector sel) {
            this.selector = sel;
            id = ids.getAndIncrement() % selectors;
            System.out.println("worker: " + id + "启动");
        }

        @Override
        public void run() {
            try {
                while (true) {
                    while (selector.select(10) > 0) {
                        System.out.println("Select");
                        Set<SelectionKey> selectionKeys = selector.selectedKeys();
                        Iterator iter = selectionKeys.iterator();
                        while (iter.hasNext()) {
                            SelectionKey key = (SelectionKey) iter.next();
                            iter.remove();
                            if (key.isAcceptable()) {
                                acceptHandler(key);
                            } else if (key.isReadable()) {
                                readHandler(key);
                            }
                        }
                    }
                    if (!boss && !queues[id].isEmpty()) {
                        try {
                            ByteBuffer buffer = ByteBuffer.allocateDirect(8192);
                            SocketChannel client = queues[id].take();
                            client.register(selector, SelectionKey.OP_READ, buffer);
                            System.out.println("----------------------------------");
                            System.out.println("新客户端" + client.socket().getPort() + "分配worker" + id);
                            System.out.println("----------------------------------");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void acceptHandler(SelectionKey key) {
            try {
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                SocketChannel client = ssc.accept();
                client.configureBlocking(false);

                int num = ids.getAndDecrement() % selectors;
                queues[num].add(client);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void readHandler(SelectionKey key) {
            SocketChannel client = (SocketChannel) key.channel();
            ByteBuffer buffer = (ByteBuffer) key.attachment();
            buffer.clear();
            int read = 0;
            try {
                while (true){
                    read = client.read(buffer);
                    if (read > 0) {
                        buffer.flip();
                        while (buffer.hasRemaining()) {
                            client.write(buffer);
                        }
                        buffer.clear();
                    } else if (read == 0) {
                        break;
                    } else {
                        client.close();
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
