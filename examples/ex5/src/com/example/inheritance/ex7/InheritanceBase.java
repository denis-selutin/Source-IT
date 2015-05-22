package com.example.inheritance.ex7;

/**
 * Created by Denis on 5/22/2015.
 */
public class InheritanceBase {
    public String v1;
    public static void main(String[] args) {
        Inheritance1 i = new Inheritance1();
        InheritanceBase i1 = i;
        System.out.println(i);
        System.out.println(i1);
        System.out.println("------------");
        System.out.println(i.v1);
        System.out.println(i1.v1);
    }
}
