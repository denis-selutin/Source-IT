package com.logistic.api.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Denis on 5/25/2015.
 */
public class Storage {
    private Map storage;

    private static class InstanceHolder {
        private static final Storage instance = new Storage();
    }

    public static Storage getInstance() {
        return InstanceHolder.instance;
    }

    private Storage() {
        this.storage = new HashMap<>();
    }

    public void putToStorage(Object id, Object value) {
        this.storage.put(id, value);
    }

    public <T> T getById(Object id) throws ClassCastException{
        return (T) this.storage.get(id);
    }
}
