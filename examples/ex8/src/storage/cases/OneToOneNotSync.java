package storage.cases;

import storage.Consumer;
import storage.Producer;
import storage.Storage;
import storage.impl.StorageNotSync;

/**
 * Created by denis.selutin on 6/2/2015.
 */
public class OneToOneNotSync {
    public static void main(String[] args) throws InterruptedException {
        Storage storage = new StorageNotSync();
        Consumer consumer = new Consumer(storage, "c1");
        Producer producer = new Producer(storage, "p1");

        runThread(producer);
        runThread(consumer);
    }

    private static void runThread(Runnable runnable) {
        Thread t = new Thread(runnable);
        t.start();
    }
}
