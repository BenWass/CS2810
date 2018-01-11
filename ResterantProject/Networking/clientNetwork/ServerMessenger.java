package clientNetwork;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import messages.Message;

public class ServerMessenger {
	
	private Socket clientSocket;
	private ObjectOutputStream outToServer;
	private ObjectInputStream inFromServer;
	private Message reply;
	
	public void sendMessage(Message msg) throws ReplyNotReadException {
		
		if(reply != null) {
			throw new ReplyNotReadException("Previous reply not read");
		}
		
		openConnetion();
		
		if(clientSocket != null) {
			try {
				outToServer.writeObject(msg);
				reply = (Message) inFromServer.readObject();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		closeConnection();
	}
	
	public Boolean checkForReply() {
		if(reply == null) {
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
	
	private void openConnetion() {
		try {
			clientSocket = new Socket("EABW1707060702",2500);
			outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
			inFromServer = new ObjectInputStream(clientSocket.getInputStream());
		} catch (UnknownHostException e) {
			System.out.println("Could not find Host name on the network");
		} catch (IOException e) {
			e.printStackTrace();
		}
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
