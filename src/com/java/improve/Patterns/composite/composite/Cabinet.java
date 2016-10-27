package com.java.improve.Patterns.composite.composite;

/**
 * 箱子Cabinet
 * Created by gongchunru on 2016/10/27.
 */
public class Cabinet extends CompositeEquipment {

    public static double cabinetNetPrice = 10.0;
    public static double cabinetDiscountPrice = 5.0;

    public Cabinet(String name) {
        super(name);
    }

    @Override
    public double discountPrice() {
        return cabinetDiscountPrice+super.discountPrice();
    }

    @Override
    public double netPrice() {
        return cabinetNetPrice+super.netPrice();
    }
}
