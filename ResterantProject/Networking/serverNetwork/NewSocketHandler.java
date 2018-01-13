package serverNetwork;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import messages.*;

public class NewSocketHandler extends Thread{

    //Fields
    private Socket clientSocket;
    private ObjectInputStream inFromClient;
    private ObjectOutputStream outToClient;
    
    //Constructor
    public NewSocketHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    
    //Methods
    @Override
    public void run() {
        try {
            openStreams();
            System.out.println("Input and Output streams open");
            Message msg = getMessage();
            System.out.println("Received new message from client");
            Message reply = testResponceSim(msg);
            sendReply(reply);
            System.out.println("Message processed, reply sent");
            closeSteams();
            System.out.println("Steams and socket closed");
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    private Message testResponceSim(Message msg) {
        System.out.println(msg.toString());
        Message relpy = new TestMessage(17);
        return relpy;
        
    }
    
    private void openStreams() throws IOException {
        inFromClient = new ObjectInputStream(clientSocket.getInputStream());
        outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
    }
    
    private void closeSteams() throws IOException {
        inFromClient.close();
        outToClient.close();
        clientSocket.close();
    }
    
    private Message getMessage() throws ClassNotFoundException, IOException {
        Message msg = (Message) inFromClient.readObject();
        return msg;
    }

    private void sendReply(Message reply) throws IOException {
        outToClient.writeObject(reply);
    }
}
