package com.java.improve.Patterns.Singleton;

/**
 * Created by gongchunru on 2016/8/4.
 * 这是个懒汉模式，多线程下不能正常工作
 */
public class Singleton01 {
    private static Singleton01 instance;

    private Singleton01(){}

    public static Singleton01 getInstance(){
        if (instance==null){
            instance=new Singleton01();
        }
        return instance;
    }

}
