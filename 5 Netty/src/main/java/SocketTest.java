import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 最简单的BIO模型
 */
public class SocketTest {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(9000);
            System.out.println("server is start");
            Socket client = server.accept();
            System.out.println("client port " + client.getPort() + " is connected");
            InputStream inputStream = client.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println(reader.readLine());
            while (true){

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
