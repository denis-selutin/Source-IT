package com.example.inheritance.ex3;

import java.io.IOException;

/**
 * Created by Denis on 5/22/2015.
 */
public class Base {
    public void m1() {}

    protected void m2() {}

    private void m3() {}

    public Object m4() {
        return this;
    }

    public Number m5(){
        return new Integer(4);
    }

    public void m6() throws IOException {}

    void m7() {

    }
}
