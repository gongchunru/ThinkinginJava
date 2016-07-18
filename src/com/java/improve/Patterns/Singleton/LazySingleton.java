package com.java.improve.Patterns.Singleton;

/**
 * Created by 龚春如 on 2016/7/18.
 */
public class LazySingleton {
    private LazySingleton(){
        System.out.println("LazySingleton is create");
    }

    private static LazySingleton instance = null;

    public static synchronized LazySingleton getInstance(){
        if (instance==null){
            instance = new LazySingleton();
        }
        return instance;
    }

}
