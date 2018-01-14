package messages;

public class TestMessage implements Message {

    /**
     * TestMessage is used to test the connection to the sever. The reply to this
     * should be a TestMessage from the server containing a string.
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
