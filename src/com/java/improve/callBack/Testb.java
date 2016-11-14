package com.java.improve.callBack;

/**
 * @author gongchunru
 * @Package com.java.improve.callBack
 * @date 16/9/15 17:14
 */
public class Testb implements ICall {
    @Override
    public void method() {
        System.out.println("回调");
    }


    public static void main(String[] args) {
        Caller caller = new Caller();
        caller.setcallFun(new Testb());
        caller.call();

    }

}
