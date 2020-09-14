package Netty;

import Netty.DiscardServer;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        DiscardServer server = new DiscardServer(9000);
        server.runServer();
    }
}
