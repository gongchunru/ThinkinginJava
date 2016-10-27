package com.java.improve.Patterns.Decorator.Decorator3;

/**
 * Created by gongchunru on 2016/10/24.
 */
public class DecoratorDemo {
    public static void main(String[] args) {

        Shape circle = new RedDecorator(new Ciracle());
        circle.draw();

        Shape rectangle = new RedDecorator(new Rectangle());
        rectangle.draw();


    }
}
