package clientNetwork;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import messages.*;

public class ServerMessenger {

    private Socket clientSocket;
    private ObjectOutputStream outToServer;
    private ObjectInputStream inFromServer;
    private Message reply;

    public void sendMessage(Message msg) throws ReplyNotReadException {

        if (reply != null) {
            throw new ReplyNotReadException("Previous reply not read");
        }

        try {
            clientSocket = new Socket("192.168.0.10", 2500);
            outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
        } catch (UnknownHostException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        if (clientSocket != null) {
            try {
                outToServer.writeObject(msg);
                inFromServer = new ObjectInputStream(clientSocket.getInputStream());
                reply = (Message) inFromServer.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        closeConnection();
    }

    public Boolean checkForReply() {
        if (reply == null) {
            return false;
        } else {
            return true;
        }
    }

    public Message getReply() {
        Message temp = reply;
        reply = null;
        return temp;
    }


    private void closeConnection() {
        try {
            inFromServer.close();
            outToServer.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
