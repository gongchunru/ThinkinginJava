package com.java.improve.Patterns.Decorator.Decorator5;

/**
 * Created by gongchunru on 2016/10/27.
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape deocoratedShape) {
        super(deocoratedShape);
    }

    @Override
    public void draw() {
        deocoratedShape.draw();
        setRedBorder(deocoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color:Red");
    }

}
