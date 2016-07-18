package com.java.improve.Patterns.Decorator;

/**
 * Created by 龚春如 on 2016/7/14.
 */
public class YanXianDecorator extends Decorator {
    @Override
    public void show() {
        super.show();
        System.out.println("With yanxian.");
    }
}
