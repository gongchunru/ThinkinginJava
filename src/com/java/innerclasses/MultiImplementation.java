package com.java.innerclasses;

/**
 * @author gongchunru
 * @Package com.java.innerclasses
 * @date 16/6/28 17:13
 */
class D{}
abstract class E{}
class Z extends D{
    E makeE(){return new E() {};}
}
public class MultiImplementation {
    static void takesD(D d){}
    static void takesE(E e){}

    public static void main(String[] args) {
        Z z = new Z();
        takesD(z);
        takesE(z.makeE());
    }
}
