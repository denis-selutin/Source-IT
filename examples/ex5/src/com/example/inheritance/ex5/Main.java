package com.example.inheritance.ex5;

/**
 * Created by Denis on 5/22/2015.
 */
public class Main {
    public static void main(String[] args) {
        StaticHolder.doSmth();
        StaticHolder2.doSmth();

        System.out.println("--------");
        StaticHolder st = new StaticHolder2();
        st.doElse();
        st.doElse2();

        System.out.println("--------");
        st = new StaticHolder();
        st.doElse();
        st.doElse2();
    }
}
