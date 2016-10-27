package com.java.improve.Patterns.Decorator.Decorator6;

/**
 * Created by gongchunru on 2016/10/27.
 */
public class Fish extends Change {

    public Fish(TheGreatestSage sage) {
        super(sage);
    }

    @Override
    public void move() {
        System.out.println("Fish move");
    }
}
