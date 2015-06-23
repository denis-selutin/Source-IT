package storage.impl;

import storage.Storage;

/**
 * Created by denis.selutin on 6/2/2015.
 */
public class StorageSync implements Storage {
    private Integer value;
    private boolean available = false;

    public synchronized void putValue(Integer val) {
        while (this.available == true) {
            try {
                System.out.println("Interrupted by " + Thread.currentThread().getName());
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        this.value = val;
        this.available = true;
        System.out.println("Continued by " + Thread.currentThread().getName());
        notifyAll();
    }

    public synchronized Integer getValue() {
        while (this.available == false) {
            try {
                System.out.println("Interrupted by " + Thread.currentThread().getName());
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        this.available = false;
        System.out.println("Continued by " + Thread.currentThread().getName());
        notifyAll();
        return this.value;
    }
}
