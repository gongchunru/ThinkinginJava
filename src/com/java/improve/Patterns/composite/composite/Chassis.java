package com.java.improve.Patterns.composite.composite;

/**
 * Created by gongchunru on 2016/10/27.
 */
public class Chassis extends CompositeEquipment {
    public static double chassisNetPrice = 2.0;
    public static double chassisDiscountPrice = 1.0;

    public Chassis(String name) {
        super(name);
    }

    @Override
    public double discountPrice() {
        return chassisDiscountPrice+super.discountPrice();
    }

    @Override
    public double netPrice() {
        return chassisNetPrice+super.netPrice();
    }
}
