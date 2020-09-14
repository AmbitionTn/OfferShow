package BIO;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author tning
 * @create 2020/09/07
 *
 * 使用线程池，为每一个连接创建一个线程去处理任务
 */
public class BioTest2 {
    private static final int PORT = 9000;
    private static final int THREAD_CNT = 5;
    private static ExecutorService executorService;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        executorService = Executors.newFixedThreadPool(THREAD_CNT);
        System.out.println("The Server is start");
        Socket client = null;
        while (null != (client = serverSocket.accept())) {
            executorService.submit(new ServerTask(client));
        }
    }
}

/**
 * 线程任务
 */
class ServerTask implements Runnable {
    private Socket client;

    public ServerTask(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            System.out.println(String.format("The client port is %s is connected", client.getPort()));
            InputStream in = client.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            System.out.println(reader.readLine());
            while (true) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
