package com.java.improve.Patterns.Decorator.Decorator6;

/**
 * Created by gongchunru on 2016/10/27.
 */
public class Change implements TheGreatestSage {

    private TheGreatestSage sage;

    public Change(TheGreatestSage sage) {
        this.sage = sage;
    }

    @Override
    public void move() {
        sage.move();
    }
}
