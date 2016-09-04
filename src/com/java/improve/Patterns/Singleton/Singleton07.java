package com.java.improve.Patterns.Singleton;

/**
 * Created by gongchunru on 2016/9/2.
 */
public class Singleton07 {
    private volatile static Singleton07 singleton07;
    private Singleton07(){}
    public static Singleton07 getSingleton07(){
        if (singleton07 == null){
            synchronized (Singleton07.class){
                if (singleton07==null){
                    singleton07 = new Singleton07();
                }
            }
        }

        return singleton07;
    }
}
