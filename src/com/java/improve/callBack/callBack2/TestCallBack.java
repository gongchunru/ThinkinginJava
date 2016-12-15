package com.java.improve.callBack.callBack2;

/**
 * @author gongchunru
 * @Package com.java.improve.callBack.callBack2
 * @date 2016/12/14 23:51
 */
public class TestCallBack {
    public static void main(String[] args) {
        Li li = new Li();

        Wang wang = new Wang(li);

        wang.askQuestion("1+1=?");
    }
}
