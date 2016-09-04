package com.java.improve.Patterns.Singleton;

/**
 * Created by gongchunru on 2016/8/29.
 * 利用classloder机制来保证初始化instance时只有一个线程，它和第三种和第四种不同的时，
 */
public class Singleton05 {

    private static class SingletonHolder{
        private static Singleton05 instance = new Singleton05();
    }
    private Singleton05(){}

    public static final Singleton05 getInstance(){
        return SingletonHolder.instance;
    }
}
