package com.java.improve.Patterns.Decorator.Decorator3;

/**
 * Created by gongchunru on 2016/10/24.
 */
public class RedDecorator extends Decorator {

    public RedDecorator(Shape decorator) {
        super(decorator);
    }

    @Override
    public void draw() {
        super.draw();
    }
}
