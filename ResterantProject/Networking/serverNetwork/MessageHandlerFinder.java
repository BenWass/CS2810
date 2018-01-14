package serverNetwork;

import messageHandlers.*;
import messages.MessageType;

public class MessageHandlerFinder {
    
    public MessageHandler getHandler(MessageType messageType) {
        MessageHandler handler;
        switch(messageType) {
            case TABLEREQUEST:
                
                break;
            case TESTMSG:
                handler = new TestMessageHandler();
                return handler;
        }
        handler = new UnrecognisedMessageHandler();
        return handler;
    }
}
