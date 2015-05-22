package com.example.inheritance.ex7;

/**
 * Created by Denis on 5/22/2015.
 */
public class Inheritance1 extends InheritanceBase {
    public String v1;
    public Inheritance1() {
        this.v1 = "Inheritance1";
        super.v1 = "InheritanceBase";
    }
    public String toString() {
        return v1;
    }
}

