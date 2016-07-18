package com.java.improve.Patterns.Singleton;

/**
 * Created by 龚春如 on 2016/7/18.
 */
public class StaticSingleton {
    //单例的构造函数都是private
    private StaticSingleton(){
        System.out.println("StaticSingleton is create");
    }

    private static class SingletonHolder{
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton instance(){
        return SingletonHolder.instance;
    }
}
