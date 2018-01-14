package messageHandlers;

import messages.Message;

public interface MessageHandler {

    /**
     * This method is called by default so any action the handler will make will
     * start in this method. As a result when this method is returned this object
     * will be destroyed. In order for the correct handler to be called for the
     * right message from the client MessageHandlerFinder will have to be updated.
     * 
     * @param msg
     *            The message received from the client
     * @return Returns the response the server wants to give. e.g. The designated
     *         table number or a request for further information.
     */
    public Message proccess(Message msg);
}
