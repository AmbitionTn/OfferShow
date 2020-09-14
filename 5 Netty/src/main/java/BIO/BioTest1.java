package BIO;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author tning
 * @create 2020/09/07
 * <p>
 * 使用一个线程的BIO只要有连接在处理任务，其他连接都会阻塞
 */
public class BioTest1 {
    private static final int PORT = 9000;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        Socket client = server.accept();
        System.out.println(String.format("The client port is %s is connected", client.getPort()));
        InputStream in = client.getInputStream();
        BufferedReader buf = new BufferedReader(new InputStreamReader(in));
        System.out.println(buf.readLine());
        while (true) {

        }
    }
}
