package com.java.improve.Patterns.duck;

/**
 * Created by gongchunru on 2016/9/6.
 */
public class DecoyDuck extends Duck2 {
    @Override
    public void display() {
        System.out.println("do nothing ");
    }

    @Override
    public void swim() {
        System.out.println("do nothing");
    }
}
