package serverNetwork;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Receriver extends Thread{
    
    //Fields
    private ServerSocket serverSocket;
    private ResponceStack responceStack;
    
    //Constructor
    public Receriver(ResponceStack responceStack) throws IOException {
        serverSocket = new ServerSocket(2500);
        this.responceStack = responceStack;
    }
    
    //Methods
    @Override
    public void run() {
        while(true) {
            try {
                Socket socket = serverSocket.accept();
                NewSocketHandler handler = new NewSocketHandler(socket,responceStack);
                handler.start();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }    
}
