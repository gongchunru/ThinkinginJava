package com.java.improve.Patterns.abstractFactoryMethod;

/**
 * Created by gongchunru on 2016/9/2.
 */
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
