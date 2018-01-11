package Messages;

public class TableRequest implements Message {

	
	@Override
	public MessageType getMessageType() {
		return MessageType.TABLEREQUEST;
	}

}
