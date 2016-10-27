package com.java.improve.Patterns.Decorator.Decorator5;

/**
 * Created by gongchunru on 2016/10/27.
 */
public abstract class ShapeDecorator implements Shape {
    protected Shape deocoratedShape;

    public ShapeDecorator(Shape deocoratedShape) {
        this.deocoratedShape = deocoratedShape;
    }

    @Override
    public void draw() {
        deocoratedShape.draw();
    }
}
