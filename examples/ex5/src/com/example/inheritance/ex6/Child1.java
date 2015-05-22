package com.example.inheritance.ex6;

/**
 * Created by Denis on 5/22/2015.
 */
public final class Child1 extends Base { //от Child1больше нелья наследоватся
//    public void m1() { //нельзя так сделать
//
//    }

    public void m2(final int i) {
        System.out.println(i);
        //i = 8; //нельзя так сделать
    }

}
