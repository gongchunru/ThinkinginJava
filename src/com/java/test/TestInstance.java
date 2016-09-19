package com.java.test;

/**
 * Created by gongchunru on 2016/9/19.
 */
public class TestInstance {
    private static TestInstance instance = null;
    private TestInstance(){}
    public TestInstance getInstance(){
        if (instance==null){
            instance = new TestInstance();
        }
        return instance;
    }
}
