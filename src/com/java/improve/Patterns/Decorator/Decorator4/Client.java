package com.java.improve.Patterns.Decorator.Decorator4;

/**
 * Created by gongchunru on 2016/10/24.
 */
public class Client {
    public static void main(String[] args) {
        Component c1 = new ConcreteComponent();
        Decorator decoratorA = new ConcreteDecoratorA(c1);
        decoratorA.operation();


    }
}
