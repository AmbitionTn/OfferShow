import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;

/**
 * @author taoning
 * @create 2020/09/06
 */
public class SocketIO {
    /**
     * 传统的BIO 每一个线程一个连接
     * NIO模型
     * NIO模型存在的问题：每一次都需要调用一次accept 并且当客户端都连接进来之后，每一次都需要遍历所有客户端，然后调用read方法
     * 即使client没有发送数据也是要遍历，很浪费资源。 while(true) accept
     * 如果每一个连接是一条路，那么现在的问题就是，每一条路都需要看一眼。
     *
     * 解决方案：将这些路交给一个设备，一个调用：当我调用这个设备的时候，它会告诉我那一条路可以去读写。【多路复用】
     * SELECT 返回一个结果，谁可读谁可写，减少了用户态和内核态切换的过程。
     * 多路复用器：只是返回IO的状态 R/W依然还是用户自己出发的 读写是自己出发的，无论是NIO还是多路复用，只要读写是自己出发的就是同步。
     * 用户空间：不会主动吧数据发回到用户空间，而是需要用户主动去读取的，这种方式叫做同步。
     *
     * NIO (non blocking) 网络内核的一个机制
     *
     * JAVA NIO (new IO) JDK
     * Channel ByteBuffer selector(多路复用器的包装）ltiltiplexing
     *
     * IO是同步的 处理是异步的
     *
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        LinkedList<SocketChannel> clients = new LinkedList<>();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress("127.0.0.1",9000));
        ssc.configureBlocking(false);

        while (true){
            Thread.sleep(1000);
            SocketChannel client = ssc.accept(); //不会阻塞
            if (client == null){
                System.out.println("null ....");
            }else {
                client.configureBlocking(false);
                int port = client.socket().getPort();
                System.out.println("client port is " + port);
                clients.add(client);
            }

            ByteBuffer buffer = ByteBuffer.allocateDirect(4096);
            for (SocketChannel c : clients){ // 串行化
                int num = c.read(buffer);   // 不会阻塞 >0获取到数据 -1没有数据 0
                if (num > 0){
                    buffer.flip();
                    byte aaa[] = new byte[buffer.limit()];
                    buffer.get(aaa);

                    String b = new String(aaa);
                    System.out.println(c.socket().getPort() + " message is " + b);
                    buffer.clear();
                }
            }
        }
    }
}
