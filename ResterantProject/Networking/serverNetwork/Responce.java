package serverNetwork;

import java.net.Socket;

import messages.*;

public class Responce {

    private Message responce;
    private Socket socket;
    
    public Responce(Message responce, Socket socket) {
        this.responce = responce;
        this.socket = socket;
    }
    
    public Message getResponce() {
        return responce;
    }
    
    public Socket getSocket() {
        return socket;
    }
}
