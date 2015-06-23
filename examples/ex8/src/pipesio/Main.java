package pipesio;

/**
 * Created by denis.selutin on 6/22/2015.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender.getPipedWriter());
        new Thread(sender).start();
        new Thread(receiver).start();
    }
}
