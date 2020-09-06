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
 * JAVA NIO 多路复用器的实现
 */
public class SocketMultiplexingSingleThread01 {

    /**
     * 创建一个服务端的监听
     */
    private ServerSocketChannel server = null;

    /**
     * 多路复用器的封装
     */
    private Selector selector = null;

    /**
     * 初始化 Server
     */
    public void initServer() {
        try {
            server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.bind(new InetSocketAddress("127.0.0.1", 9000));

            selector = Selector.open();
            server.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        initServer();
        System.out.println("服务器启动。。。。");

        try {
            while (true) {
                /**
                 * select方法中参数为0代表一直阻塞，直到获得select连接
                 * select方法返回值大于0 代表内核中已经有准备好的事件。
                 */
                while (selector.select(0) > 0) {
                    // 从多路复用器中取出有效的连接
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()) {
                        // 取出事件
                        SelectionKey key = iterator.next();
                        iterator.remove();

                        if (key.isAcceptable()) {
                            acceptHandler(key);
                        } else if (key.isReadable()){
                            System.out.println("一般情况下有数据到达的时候会触发，什么时候会疯狂触发");
                            readHandler(key);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 处理接收请求
     *
     * @param key
     */
    public void acceptHandler(SelectionKey key) {
        try {
            // 通过key可以取出放进Select里面的channel
            ServerSocketChannel ssr = (ServerSocketChannel) key.channel();
            SocketChannel client = ssr.accept();
            client.configureBlocking(false);
            ByteBuffer buffer = ByteBuffer.allocateDirect(8192);
            // clikey 可以拿回channel 也可以拿到 buffer
            client.register(selector, SelectionKey.OP_READ, buffer);
            System.out.println("-----------------------------------");
            System.out.println("新客户端连接：" + client.getRemoteAddress());
            System.out.println("-----------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读请求处理方法
     */
    public void readHandler(SelectionKey key){
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        buffer.clear();

        int read = 0;
        try {
            while (true){
                read = client.read(buffer);
                if (read > 0){
                    buffer.flip();
                    while (buffer.hasRemaining()){
                        client.write(buffer);
                    }
                    buffer.clear();
                }else if (read == 0){
                    break;
                }
//                else {
//                    client.close();  // -1 客户端close
//                    break;
//                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SocketMultiplexingSingleThread01 test = new SocketMultiplexingSingleThread01();
        test.start();
    }
}
