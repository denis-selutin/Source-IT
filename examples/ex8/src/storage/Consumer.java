package storage;

/**
 * Created by denis.selutin on 6/2/2015.
 */
public class Consumer implements Runnable {
    private Storage storage;
    private String name;
    public Consumer(Storage storage, String name) {
        this.storage = storage;
        this.name = name;
    }

    @Override
    public void run() {
        int value = 0;
        for (int i = 0; i < 10; i++) {
            value = storage.getValue();
            System.out.println("Consumer #" + this.name + " got: " + value + " " + Thread.currentThread().getName());
        }
    }
}
