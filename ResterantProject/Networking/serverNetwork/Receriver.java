package serverNetwork;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Receriver extends Thread{
    
    //Fields
    private ServerSocket serverSocket;
    
    //Constructor
    public Receriver() throws IOException {
        serverSocket = new ServerSocket(2500);
    }
    
    //Methods
    @Override
    public void run() {
        while(true) {
            try {
                System.out.println("Lissening for connection on port 2500");
                Socket socket = serverSocket.accept();
                System.out.println("New socket connection on port 2500");
                NewSocketHandler handler = new NewSocketHandler(socket);
                handler.start();
                System.out.println("Socket given to Socket handler");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }    
}
