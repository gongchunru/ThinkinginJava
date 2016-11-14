package com.java.improve.Patterns.ProtorypePattern;

/**
 * @author gongchunru
 * @Package com.java.improve.Patterns.ProtorypePattern
 * @date 16/9/7 02:27
 */
public class Circle extends Shape {
    public Circle() {
        type = "Circle";
    }

    @Override
    void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
