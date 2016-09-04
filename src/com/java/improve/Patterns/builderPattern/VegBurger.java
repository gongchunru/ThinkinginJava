package com.java.improve.Patterns.builderPattern;

/**
 * Created by gongchunru on 2016/9/2.
 */
public class VegBurger extends Burger {
    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name(){
        return "Veg Burger";
    }
}
