package com.java.test;

/**
 * Created by gongchunru on 2016/9/19.
 */
public class TestSimple {
    public static void main(String[] args) {
        try {
            System.out.println(Math.round(11.5));
            return;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("finally");
        }
    }
}
