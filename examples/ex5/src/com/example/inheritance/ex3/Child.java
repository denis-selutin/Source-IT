package com.example.inheritance.ex3;

/**
 * Created by Denis on 5/22/2015.
 */
public class Child extends Base {
    public void m1() {}

    protected void m2() {}

    private void m3() {} //ошибки не будет, но мы не переопределили метод базового класса - мы просто создали новый метод для текузего класса

    public Integer m4() {
        return new Integer(5);
    }

//    public Object m5(){ так нельзя!!!
//        return new Integer(4);
//    }

    //public void m6() throws Exception {} //так нельзя!!!
    public void m6() {}

    public void m7() {

    }
}
