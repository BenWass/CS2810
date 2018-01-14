package messageHandlers;

import messages.Message;
import messages.TestMessage;

public class UnrecognisedMessageHandler implements MessageHandler {

    @Override
    public Message proccess(Message msg) {
        Message reply = new TestMessage("UnrecognisedMessage");
        return reply;
    }

}
