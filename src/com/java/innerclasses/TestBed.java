package com.java.innerclasses;

/**
 * @author gongchunru
 * @Package com.java.innerclasses
 * @date 16/6/28 16:38
 */
public class TestBed {
    public void f(){
        System.out.println("f()");
    }

    public static class Tester{
        public static void main(String[] args) {
            TestBed t = new TestBed();
            t.f();
        }
    }
}
