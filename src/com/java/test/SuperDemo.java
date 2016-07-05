package com.java.test;

/**
 * @author gongchunru
 * @Package com.java.test
 * @date 16/5/26 22:08
 */
public class SuperDemo {
    public static void main(String[] args) {
        new Sub();
    }
}

class Super{
    int a = 5;
    public Super() {
        System.out.println(a);
        test();
    }
    public void test(){
        System.out.println(a);
    }
}

class Sub extends Super{
    int a = 6;
    public void test(){
        System.out.println(a);
    }
}