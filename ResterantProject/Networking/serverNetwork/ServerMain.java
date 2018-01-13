package serverNetwork;

import java.io.IOException;

public class ServerMain {

    private ResponceStack responceStack;
    private Receriver receiver;
    private SenderHandler senderHandler;
    
    public ServerMain () throws IOException {
        responceStack = new ResponceStack();
        senderHandler = new SenderHandler(responceStack);
        receiver = new Receriver(responceStack);
    }
    
    public void start() {
        receiver.start();
        senderHandler.start();
        
        
    }
}
