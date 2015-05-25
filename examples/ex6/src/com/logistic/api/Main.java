package com.logistic.api;

import com.logistic.api.service.Storage;

/**
 * Created by Denis on 5/25/2015.
 */
public class Main {
    public static void main(String[] args) {
        Storage.getInstance().putToStorage("1", "Bla");
        Storage.getInstance().putToStorage("2", new Integer(45));


        Integer i = Storage.getInstance().<Integer>getById("2");
        String s = Storage.getInstance().<String>getById("1");

        System.out.println(i);
        System.out.println(s);
        //i = Storage.getInstance().<Integer>getById("1");// don't do like this!!!! You should know about the type inside!!!
        System.out.println(Storage.getInstance().<Integer>getById("1"));// But you can do this here java doesn't do a cast to a variable
    }
}
