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

/**
 * @author tning
 * @create 2020/09/07
 * <p>
 * 单线程IO多路复用模型
 */
public class MultiplexingTest1 {
    private ServerSocketChannel server = null;
    private Selector selector = null;

    private final String HOST = "127.0.0.1";
    private final int PORT = 9000;

    /**
     * 初始化Server监听
     */
    public void initServer() {
        try {
            server = ServerSocketChannel.open();
            server.bind(new InetSocketAddress(HOST, PORT));
            server.configureBlocking(false);

            selector = Selector.open();
            server.register(selector, SelectionKey.OP_ACCEPT); //为Server注册连接事件
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 启动Server
     */
    public void runServer() {
        initServer();
        System.out.println("The server is start .....");
        try {
            while (true) {
                while (selector.select() > 0) {
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iter = selectionKeys.iterator();
                    while (iter.hasNext()) {
                        SelectionKey key = iter.next();
                        iter.remove();

                        if (key.isAcceptable()) {
                            acceptHander(key);
                        } else if (key.isReadable()) {
                            readHandler(key);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
        }
    }

    /**
     * 处理连接请求
     *
     * @param key
     */
    private void acceptHander(SelectionKey key) {
        try {
            ServerSocketChannel server = (ServerSocketChannel) key.channel();
            SocketChannel client = server.accept();
            client.configureBlocking(false);

            ByteBuffer buffer = ByteBuffer.allocateDirect(8192);
            client.register(selector, SelectionKey.OP_READ, buffer);

            System.out.println("---------------------------------");
            System.out.println(String.format("The client port %s is connnected", client.socket().getPort()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取请求
     *
     * @param key
     */
    private void readHandler(SelectionKey key) {
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        buffer.clear();

        int read = 0;
        try {
            while (true) {
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

    public static void main(String[] args) {
        MultiplexingTest1 server = new MultiplexingTest1();
        server.runServer();
    }
}
