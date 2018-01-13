package serverNetwork;

public class SenderHandler extends Thread{
    
    private ResponceStack responceStack;
    
    public SenderHandler(ResponceStack responceStack) {
        this.responceStack = responceStack;
    }
    
    public void addResponcetoStack(Responce tmp) {
        responceStack.addResponce(tmp);
    }
    
    @Override
    public void run() {
        while(true) {
            if(!responceStack.isEmpty()) {
                Responce responce = responceStack.pop();
                Sender sender = new Sender(responce);
                sender.sendReply();
            };
        }
    }
}
