package com.java.test;

/**
 * @author gongchunru
 * @Package com.java.test
 * @date 2016/11/23 22:29
 */
public class TestCode {
    static class Parent{
        public static int A = 1;
        static {
            A = 2;
        }
    }

    static class Sub extends Parent{
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B);
    }



}
