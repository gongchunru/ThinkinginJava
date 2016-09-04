package com.java.improve.Patterns.builderPattern;

/**
 * Created by gongchunru on 2016/9/2.
 */
public abstract  class ColdDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
