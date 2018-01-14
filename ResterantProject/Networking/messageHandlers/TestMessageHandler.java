package messageHandlers;

import messages.Message;
import messages.TestMessage;

public class TestMessageHandler implements MessageHandler{

    @Override
    public Message proccess(Message msg) {
        System.out.println("Message from client: " + msg.toString());
        Message reply = new TestMessage("Hello from server");
        return reply;
    }

}
