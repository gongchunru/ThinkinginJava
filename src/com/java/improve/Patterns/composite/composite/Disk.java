package com.java.improve.Patterns.composite.composite;

/**
 * Created by gongchunru on 2016/10/27.
 */
public class Disk extends Equipment {

    public static double diskNetPrice = 2.0;

    public static double diskDiscountPrice = 1.0;

    public Disk(String name) {
        super(name);
    }

    @Override
    public double netPrice() {
        return diskNetPrice;
    }

    @Override
    public double discountPrice() {
        return diskDiscountPrice;
    }
}
