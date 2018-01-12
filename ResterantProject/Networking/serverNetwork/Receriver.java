package serverNetwork;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Receriver {
    
    //Fields
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private SocketHandler handler;
    
    //Constructor
    public Receriver() throws IOException {
        serverSocket = new ServerSocket(2500);
        
    }
    
    //Methods
    public void start() throws IOException {
        handler = new SocketHandler(serverSocket.accept());
    }
    
    
}
