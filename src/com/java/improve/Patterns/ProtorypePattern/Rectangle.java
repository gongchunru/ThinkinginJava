package com.java.improve.Patterns.ProtorypePattern;

/**
 * @author gongchunru
 * @Package com.java.improve.Patterns.ProtorypePattern
 * @date 16/9/7 02:25
 */
public class Rectangle  extends Shape{
    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Inside Rectangle : draw() method");
    }
}
