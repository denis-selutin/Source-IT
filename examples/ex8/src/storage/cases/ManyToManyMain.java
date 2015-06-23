package storage.cases;

import storage.Consumer;
import storage.Producer;
import storage.Storage;
import storage.impl.StorageSync;

/**
 * Created by denis.selutin on 6/2/2015.
 */
public class ManyToManyMain {
    public static void main(String[] args) {
        Storage storage = new StorageSync();
        for(int i=0; i<10; i++) {
            Consumer consumer = new Consumer(storage, "c" + i);
            Producer producer = new Producer(storage, "p" + i);

            runThread(consumer);
            runThread(producer);
        }
    }

    private static void runThread(Runnable runnable) {
        Thread t = new Thread(runnable);
        t.start();
    }
}
