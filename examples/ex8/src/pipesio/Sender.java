package pipesio;

import java.io.PipedWriter;
import java.util.Random;

/**
 * Created by denis.selutin on 6/22/2015.
 */
public class Sender implements Runnable {
    private Random rand = new Random();
    private PipedWriter out = new PipedWriter();
    public PipedWriter getPipedWriter() { return out; }
    public void run() {
        while(true) {
            for(char c = 'A'; c <= 'z'; c++) {
                try {
                    out.write(c);
                    Thread.sleep(rand.nextInt(5000));
                } catch(Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}