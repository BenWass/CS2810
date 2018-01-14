package messageHandlers;

import messages.Message;

public interface MessageHandler {

    public Message proccess(Message msg);
}
