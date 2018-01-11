package messages;

public class TableRequest implements Message {

    private int tableSize;
    
	public TableRequest(int tableSize) {
	    this.tableSize = tableSize; 
	}
    
    
	public int getTableSize() {
	    return tableSize;
	}
	
	@Override
	public MessageType getMessageType() {
		return MessageType.TABLEREQUEST;
	}

}
