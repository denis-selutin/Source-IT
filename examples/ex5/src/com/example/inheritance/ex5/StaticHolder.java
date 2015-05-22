package com.example.inheritance.ex5;

/**
 * Created by Denis on 5/22/2015.
 */
public class StaticHolder {
    public static String CONTS_1 = "Constatnt #1";

    public static void doSmth() {
        System.out.println("StaticHolder");
    }

    public void doElse(){
        System.out.println(CONTS_1);
    }

    public void doElse2(){
        System.out.println(CONTS_1);
    }
}
