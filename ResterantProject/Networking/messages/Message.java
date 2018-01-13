package messages;

import java.io.Serializable;

public interface Message extends Serializable{
	
	public MessageType getMessageType();
	
	public String toString();
}
