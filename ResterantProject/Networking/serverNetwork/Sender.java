package serverNetwork;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import messages.*;

public class Sender {

    public Sender() {
        
    }
    
    public void sendReply(Socket socket, Message msg) {
        try {
            ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
            outToServer.writeObject(msg);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
