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
    private ResponceStack responceStack;
    
    //Constructor
    public NewSocketHandler(Socket clientSocket,ResponceStack responceStack) {
        this.clientSocket = clientSocket;
        this.responceStack = responceStack;
    }
    
    //Methods
    @Override
    public void run() {
        try {
            openInputStream();
            Message msg = getMessage();
            closeInputStream();
            Responce reply = testResponceSim(msg);
            responceStack.addResponce(reply);
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    private Responce testResponceSim(Message msg) {
        System.out.println(msg.toString());
        Message replyTest = new TestMessage(18);
        Responce reply = new Responce(replyTest,clientSocket);
        return reply;
    }
    
    private void openInputStream() throws IOException {
        inFromClient = new ObjectInputStream(clientSocket.getInputStream());
    }
    
    private void closeInputStream() throws IOException {
        inFromClient.close();
    }
    
    private Message getMessage() throws ClassNotFoundException, IOException {
        Message msg = (Message) inFromClient.readObject();
        return msg;
    }
}
