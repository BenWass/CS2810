package messages;

import java.io.Serializable;

public interface Message extends Serializable {

    /**
     * This method is used to define the type of message being sent. This is done
     * through the use of the enums in the MessageType file. As such if you make a
     * new message you will need to add the new type of message to the enum file.
     * 
     * @return Returns the type of Message being sent.
     */
    public MessageType getMessageType();

    /**
     * This method is used to return a string message that describes the exacts of
     * the message i.e. "table request for 5 people". This will predominately used
     * for logging and debugging.
     * 
     * @return Returns a summary of the message as a string.
     */
    public String toString();
}
