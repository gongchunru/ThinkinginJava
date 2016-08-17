package com.java.newFeatures.func;


/**
 * Created by 龚春如 on 2016/7/29.
 */
public class FunctionManager {

    public void remote(){
        Remote proxy = new Remote();
        proxy.service(this::callBack);
    }

    public void callBack(String a,String b){
        System.out.println(a+"  "+b);
    }
}
