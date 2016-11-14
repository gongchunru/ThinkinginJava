package com.java.improve.Patterns.builderPattern.builderPattern2;

/**
 * Created by gongchunru on 2016/11/14.
 */
public class XiaoGuang {
    public static void main(String[] args) {
        HotDryNoodles noodlesA  = new HotDryNoodles(true,true,true,true);
        System.out.println("Customer A wants : "+noodlesA);

        HotDryNoodles noodlesB = new HotDryNoodles(true,false,false,true);
        System.out.println("Customer B wants: "+noodlesB);
    }
}
