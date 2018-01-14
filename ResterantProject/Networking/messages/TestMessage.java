package messages;

public class TestMessage implements Message{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String msg;
    
    public TestMessage(String msg) {
        this.msg = msg;
    }
    
    @Override
    public MessageType getMessageType() {
        return MessageType.TESTMSG;
    }
    
    public String toString() {
        return "Test message containg the following test string: " + msg;
    }
}
