package com.example.inheritance.ex1;

import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;

/**
 * Created by Denis on 5/19/2015.
 */
public class Inheritance1 extends InheritanceBase {

//    protected void myMethod() throws Exception { //выдаст ошибку
//
//    }

    public Inheritance1 getInstance() {
        return null;
    }

    public static class Inheritance2 extends InheritanceBase {
        protected void myMethod() throws FileNotFoundException, FileAlreadyExistsException{

        }
    }

    public static class Inheritance3 extends InheritanceBase {
        protected void myMethod() {

        }
    }
}
