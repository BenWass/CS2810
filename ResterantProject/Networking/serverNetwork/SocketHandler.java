package serverNetwork;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import messages.*;

public class SocketHandler {

    //Fields
    private Socket clientSocket;
    private ObjectInputStream inFromClient;
    private ObjectOutputStream outToClient;
    
    //Constructor
    public SocketHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    
    //Methods
    public void start() {
        try {
            openStreams();
            Message msg = getMessage();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void openStreams() throws IOException {
        inFromClient = new ObjectInputStream(clientSocket.getInputStream());
        outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
    }
    
    public Message getMessage() throws ClassNotFoundException, IOException {
        Message msg = (Message) inFromClient.readObject();
        return msg;
    }
}
