package com.java.improve.Patterns.builderPattern;

/**
 * Created by gongchunru on 2016/9/2.
 */
public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}
