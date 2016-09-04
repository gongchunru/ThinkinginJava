package com.java.improve.Patterns.abstractFactoryMethod;

import com.java.improve.Patterns.factoryMethod.*;

/**
 * Created by gongchunru on 2016/9/2.
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
