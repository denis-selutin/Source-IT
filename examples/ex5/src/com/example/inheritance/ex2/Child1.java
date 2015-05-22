package com.example.inheritance.ex2;

/**
 * Created by Denis on 5/22/2015.
 */
public class Child1 extends Base {
    public String V1 = "Child";

    public String getV1() {
        return V1;
    }

    public Child1() {
        System.out.println("Constructor child");
    }

    public Child1(String v1) {
        System.out.println("Constructor child overloaded");
    }

    public static void main(String[] args) {
        Child1 c = new Child1();
        System.out.println("----------");
        Base b = new Base();
        System.out.println("----------");
        Base bc = new Child1();
        System.out.println("----------");

        System.out.println(c.getV1());
        System.out.println(b.getV1());
        System.out.println(bc.getV1());
        System.out.println("----------");

        System.out.println(c.V1);
        System.out.println(b.V1);
        System.out.println(bc.V1); //будет братся переменная мз Base!!!
    }
}
