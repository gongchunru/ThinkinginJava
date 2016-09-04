package com.java.improve.Patterns.Singleton;

/**
 * Created by gongchunru on 2016/8/4.
 * 这种方式基于classLoader机制避免了很多问题，不过，
 * instance在类加载时就实例化，
 */
public class Singleton03 {
    private static Singleton03 instance = new Singleton03();

    private Singleton03(){}

    public static Singleton03 getInstance(){
        return instance;
    }
}
