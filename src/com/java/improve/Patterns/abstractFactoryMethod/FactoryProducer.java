package com.java.improve.Patterns.abstractFactoryMethod;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by gongchunru on 2016/9/2.
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("SHAPE")) {
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("COLOR")) {
            return new ColorFactory();
        }
        return null;

    }
}
