/**
 * Created by denis.selutin on 6/2/2015.
 */
public class ExtendsThread extends Thread{
    @Override
    public void run() {
        System.out.println("Inside thread " + getId());
        long current = System.currentTimeMillis();
        while(System.currentTimeMillis() - current < 5000) {
            for(int i=0; i<10000; i++) {}
            //System.out.println("Time " + (System.currentTimeMillis() - current));
        }
        System.out.println("Finished thread " + getId());
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Outer thread " + Thread.currentThread().getId());
        for(int i = 0; i < 10; i++) {
            Thread myThread = new ExtendsThread();
            myThread.start();
        }

    }
}
