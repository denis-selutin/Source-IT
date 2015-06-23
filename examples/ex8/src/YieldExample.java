/**
 * Created by denis.selutin on 6/23/2015.
 */
public class YieldExample implements Runnable {
    private Thread t;

    public YieldExample(String str) {
        t = new Thread(this, str);
        t.start();
    }

    public void run() {
        System.out.println(Thread.currentThread().getState());
        for (int i = 0; i < 5000000; i++) {
            // передача управления другому потоку каждые 5 операций
            if ((i % 10000) == 0) {
                System.out.println(Thread.currentThread().getName() + " yielding control...");
                Thread.yield();
                System.out.println(Thread.currentThread().getName() + " starting execution..." + Thread.currentThread().getState());
            }
        }
        System.out.println(Thread.currentThread().getName() + " has finished executing.");
    }

    public static void main(String[] args) {
        new YieldExample("Thread 1");
        new YieldExample("Thread 2");
        //new YieldExample("Thread 3");
    }
}
