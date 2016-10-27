package com.java.improve.Patterns.Decorator.Decorator2;

/**
 * Created by 龚春如 on 2016/7/14.
 */

//定义被装饰者，被装饰者初始状态有些自己的装饰。
public class Person  implements Human{


    @Override
    public void wearClothes() {
        System.out.println("穿什么呢？");
    }

    @Override
    public void walkToWhere() {
        System.out.println("去哪里呢？");
    }
}
