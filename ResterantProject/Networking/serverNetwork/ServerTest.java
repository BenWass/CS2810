package serverNetwork;

import java.io.IOException;

public class ServerTest {

    public static void main(String[] args) {
        try {
            ServerMain server = new ServerMain();
            server.start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
