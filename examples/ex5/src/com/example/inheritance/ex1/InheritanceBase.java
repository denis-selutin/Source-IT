package com.example.inheritance.ex1;

/**
 * Created by Denis on 5/19/2015.
 */
public class InheritanceBase {
    protected void myMethod() throws Throwable {

    }

    public InheritanceBase getInstance() {
        return null;
    }

    public static void main(String[] args) {
        Inheritance1.Inheritance3 i = new Inheritance1.Inheritance3();
        i.myMethod();
    }
}
