package com.java.innerclasses;

/**
 * @author gongchunru
 * @Package com.java.innerclasses
 * @date 16/6/28 17:08
 */

interface A{}
interface B{}

class X implements A,B{}

class Y implements A{
    B makeB(){
        return new B() {
        };
    }
}
public class MultiInterfaces {
    static void takesA(A a){}
    static void takesB(B b){}

    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();
        takesA(x);
        takesA(y);
        takesB(x);
        takesB(y.makeB());
    }
}
