package storage;

/**
 * Created by denis.selutin on 6/2/2015.
 */
public class Producer implements Runnable {
    private Storage storage;
    private String name;
    public Producer(Storage storage, String name) {
        this.storage = storage;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            storage.putValue(i);
            System.out.println("Producer #" + this.name + " put: " + i + " " + Thread.currentThread().getName());
            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) { }
        }
    }
}
