package com.java.improve.Patterns.Decorator;

/**
 * Created by 龚春如 on 2016/7/14.
 */
public class OtherDecorator extends Decorator {
    @Override
    public void show() {
        super.show();
        System.out.println("With other huazhuangpin");
    }
}
