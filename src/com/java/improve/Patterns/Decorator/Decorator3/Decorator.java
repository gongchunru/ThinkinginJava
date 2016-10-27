package com.java.improve.Patterns.Decorator.Decorator3;

/**
 * Created by gongchunru on 2016/10/24.
 */
public abstract class Decorator implements Shape {
    protected Shape decorator;

    public Decorator(Shape decorator) {
        this.decorator = decorator;
    }

    public void draw(){
        decorator.draw();
    }
}
