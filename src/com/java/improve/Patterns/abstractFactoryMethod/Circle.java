package com.java.improve.Patterns.abstractFactoryMethod;

/**
 * Created by gongchunru on 2016/9/2.
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
