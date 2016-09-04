package com.java.improve.Patterns.Singleton;

/**
 * Created by gongchunru on 2016/9/2.
 */
public class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton(){}

    public static Singleton getSingleton(){
        return singleton;
    }
}
