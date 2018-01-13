package messages;

public class TestMessage implements Message{

    private Integer i;
    
    public TestMessage(int i) {
        this.i = i;
    }
    
    @Override
    public MessageType getMessageType() {
        return MessageType.TESTMSG;
    }
    
    public String toString() {
        return i.toString();
    }
}
