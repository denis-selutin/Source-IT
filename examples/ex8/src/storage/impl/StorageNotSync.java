package storage.impl;

import storage.Storage;

/**
 * Created by denis.selutin on 6/2/2015.
 */
public class StorageNotSync implements Storage {
    private Integer value;

    public void putValue(Integer val) {
        this.value = val;
    }

    public Integer getValue() {
        return this.value;
    }
}
