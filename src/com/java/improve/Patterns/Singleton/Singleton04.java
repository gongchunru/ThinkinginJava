package com.java.improve.Patterns.Singleton;

/**
 * Created by gongchunru on 2016/8/29.
 * 饿汉的变种，
 */
public class Singleton04 {
    private static Singleton04 instance = null;
    static {
        instance = new Singleton04();
    }

    private Singleton04(){}

    public static Singleton04 getInstance(){
        return instance;
    }
}
