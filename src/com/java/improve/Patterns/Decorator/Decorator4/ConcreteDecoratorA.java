package com.java.improve.Patterns.Decorator.Decorator4;

/**
 * Created by gongchunru on 2016/10/24.
 */
public class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    private void operationFirst(){}
    private void operationLast(){}

    public void operation(){
        operationFirst();
        super.operation();
        operationLast();
    }
}
