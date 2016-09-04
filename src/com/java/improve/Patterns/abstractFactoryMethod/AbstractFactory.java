package com.java.improve.Patterns.abstractFactoryMethod;

/**
 * Created by gongchunru on 2016/9/2.
 */
public abstract class AbstractFactory {
    abstract Color getColor(String color);
    abstract Shape getShape(String shape);
}
