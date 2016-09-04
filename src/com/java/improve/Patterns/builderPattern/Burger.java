package com.java.improve.Patterns.builderPattern;

/**
 * Created by gongchunru on 2016/9/2.
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
