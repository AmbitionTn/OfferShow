package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;

/**
 * @author tning
 * @create 2020/09/07
 * <p>
 * 使用NIO无阻塞
 */
public class NioTest {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 9000;
    private static LinkedList<SocketChannel> clients = new LinkedList<>();

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(new InetSocketAddress(HOST, PORT));
        server.configureBlocking(false); //设置server为非阻塞

        while (true) {
            Thread.sleep(1000);
            SocketChannel client = server.accept(); //设置为非阻塞后，这里不会阻塞
            if (null == client) {
                System.out.println("null ..........");
            } else {
                client.configureBlocking(true); //设置客户端为非阻塞
                int port = client.socket().getPort();
                System.out.println(String.format("The client port %s is connected", port));
                clients.add(client);
            }

            ByteBuffer buffer = ByteBuffer.allocateDirect(4096);    // 多个客户端公用一个ByteBuffer
            for (SocketChannel c : clients) {
                System.out.println("The client is connnet");
                int num = c.read(buffer);
                System.out.println("The client is connnet");
                if (num > 0) {
                    buffer.flip();
                    byte tmp[] = new byte[buffer.limit()];
                    buffer.get(tmp);

                    String msg = new String(tmp);
                    System.out.println(String.format("The client message is %s", msg));
                    buffer.clear();
                }
            }
        }
    }
}
