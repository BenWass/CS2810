package serverNetwork;

import java.io.IOException;

public class ServerMain {

    private Receriver receiver;
    
    public ServerMain () throws IOException {
        receiver = new Receriver();
    }
    
    public void start() {
        System.out.println("Starting receiver");
        receiver.start();
        System.out.println("Receiver running");
    }
}
