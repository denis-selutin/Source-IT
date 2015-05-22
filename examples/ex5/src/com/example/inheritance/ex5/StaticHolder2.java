package com.example.inheritance.ex5;

/**
 * Created by Denis on 5/22/2015.
 */
public class StaticHolder2 extends StaticHolder {
    public static String CONTS_1 = "Constatnt #2";

    public static void doSmth() {
        System.out.println("StaticHolder2");
    }

    public void doElse(){
        System.out.println(CONTS_1);
        System.out.println(this);
    }
}
