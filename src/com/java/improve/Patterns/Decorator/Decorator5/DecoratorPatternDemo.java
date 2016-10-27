package com.java.improve.Patterns.Decorator.Decorator5;

/**
 * Created by gongchunru on 2016/10/27.
 */
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();

        Shape redCircle = new RedShapeDecorator(new Circle());

        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
