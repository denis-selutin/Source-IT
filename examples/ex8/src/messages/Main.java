package messages;

import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by denis.selutin on 6/18/2015.
 */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.setOut(new PrintStream(System.out) {
            @Override
            public void println(String x) {
                super.println(Thread.currentThread().getName() + " --> " + x);
            }
        });

        ExecutorService es = Executors.newFixedThreadPool(50);
        es.execute(new Server(Server.portNumber, es));
        System.out.println("Server has been started");
        for(int i = 0; i < 3; i++) {
            es.execute(new Client());
        }
    }
}
