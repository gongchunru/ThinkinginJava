package com.java.improve.Patterns.future;

/**
 * Created by gongchunru on 2016/10/21.
 */
public class TestMain {
    public static void main(String[] args) {
        Data data = new Client().request("123445");
        System.out.println(data);
        System.out.println(data.getResult());
    }
}
