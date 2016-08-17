package com.java.newFeatures.func;

/**
 * Created by 龚春如 on 2016/7/29.
 */
public class Remote {
    public void service(Function<String,String> str){
        str.apply("Hello","wolrd");
    }
}
