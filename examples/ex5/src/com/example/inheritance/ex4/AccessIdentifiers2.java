package com.example.inheritance.ex4;

import com.example.inheritance.ex3.Child;

import java.io.Serializable;

/**
 * Created by Denis on 5/22/2015.
 */
public class AccessIdentifiers2 extends Child implements Cloneable, Serializable {
    public void m1() {}

    protected void m2() {}

    public Integer m4() {
        return new Integer(4);
    }

    public Number m5(){
        return new Integer(4);
    }

    public void m6() {}

    public void m7() {} // перегрузит m7 из Child
}
