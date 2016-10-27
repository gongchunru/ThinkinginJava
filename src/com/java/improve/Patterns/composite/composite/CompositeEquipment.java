package com.java.improve.Patterns.composite.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gongchunru on 2016/10/27.
 */
public abstract class CompositeEquipment extends Equipment {

    private int i = 0;

    //定义一个list用来保存组合体内的各个子对象
    private List<Equipment> equipments = new ArrayList<Equipment>();


    public CompositeEquipment(String name) {
        super(name);
    }

    @Override
    public double netPrice() {
        double netPrice = 0;
        if (this instanceof Cabinet){

        }
        return 0;
    }

    @Override
    public double discountPrice() {
        return 0;
    }
}
