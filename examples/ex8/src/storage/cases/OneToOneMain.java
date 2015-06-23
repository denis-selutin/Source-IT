package storage.cases;

import storage.Consumer;
import storage.Producer;
import storage.Storage;
import storage.impl.StorageSync;

/**
 * Created by denis.selutin on 6/2/2015.
 */
public class OneToOneMain {
    public static void main(String[] args) {
        Storage storage = new StorageSync();
        Consumer consumer = new Consumer(storage, "c1");
        Producer producer = new Producer(storage, "p1");

        runThread(consumer);
        runThread(producer);
    }

    private static void runThread(Runnable runnable) {
        Thread t = new Thread(runnable);
        System.out.println(t.getName() + " " + t.getState());
        new ThreadStatePrinter(t).start();
        t.start();
    }

    private static class ThreadStatePrinter extends Thread {
        private Thread t;
        public ThreadStatePrinter(Thread t){
            this.t = t;
        }

        @Override
        public void run() {
            while(t.getState() != State.TERMINATED) {
                System.out.println(getName() + " " + getState() + " for " + t.getName() + " " + t.getState());
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
