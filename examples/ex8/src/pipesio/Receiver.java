package pipesio;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Created by denis.selutin on 6/22/2015.
 */
public class Receiver implements Runnable {
    private PipedReader in;
    public Receiver(PipedWriter sender) throws IOException {
        in = new PipedReader(sender);
    }
    public void run() {
        try {
            while(true) {
                // Blocks until characters are there:
                System.out.println("Read: " + (char)in.read());
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
