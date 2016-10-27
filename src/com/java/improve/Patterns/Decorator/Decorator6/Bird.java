package com.java.improve.Patterns.Decorator.Decorator6;

/**
 * Created by gongchunru on 2016/10/27.
 */
public class Bird extends Change {
    public Bird(TheGreatestSage sage) {
        super(sage);
    }

    @Override
    public void move() {
        System.out.println("Bird Move");
    }
}
