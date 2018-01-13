package clientNetwork;

import messages.Message;
import messages.TestMessage;

public class ClientTest {

    public static void main(String[] args) {
        Message request = new TestMessage(21);
        ServerMessenger messenger = new ServerMessenger();
        try {
            messenger.sendMessage(request);
            System.out.println(messenger.getReply().toString());
        } catch (ReplyNotReadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
