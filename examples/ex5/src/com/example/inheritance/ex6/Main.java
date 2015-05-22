package com.example.inheritance.ex6;

/**
 * Created by Denis on 5/22/2015.
 */
public class Main {
    public static void main(String[] args) {
        Base b1 = new Child1();
        Base b2 = new Base();

        System.out.println(b1 instanceof Base);
        System.out.println(b1 instanceof Child1);

        System.out.println("----------------");
        System.out.println(b2 instanceof Base);
        System.out.println(b2 instanceof Child1);

        System.out.println("----------------");
        System.out.println(Base.class.isAssignableFrom(b1.getClass()));
        System.out.println(Child1.class.isAssignableFrom(b1.getClass()));

        System.out.println("----------------");
        System.out.println(Base.class.isAssignableFrom(b2.getClass()));
        System.out.println(Child1.class.isAssignableFrom(b2.getClass()));
    }
}
