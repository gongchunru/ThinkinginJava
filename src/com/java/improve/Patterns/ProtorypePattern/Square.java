package com.java.improve.Patterns.ProtorypePattern;

/**
 * @author gongchunru
 * @Package com.java.improve.Patterns.ProtorypePattern
 * @date 16/9/7 02:26
 */
public class Square extends Shape {

    public Square(){
        type = "Square";
    }

    @Override
    void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
