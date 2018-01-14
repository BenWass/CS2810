package clientNetwork;

import messages.Message;
import messages.TestMessage;

public class ClientTest {

    public static void main(String[] args) {
        Message request = new TestMessage("Hello From Client");
        System.out.println("Created message");
        ServerMessenger messenger = new ServerMessenger();
        System.out.println("Created Messenger");
        try {
            messenger.sendMessage(request);
            System.out.println("Message sent");
            System.out.println("Message received from server: " + messenger.getReply().toString());
        } catch (ReplyNotReadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
