package com.java.improve.Patterns.composite.composite;

import java.util.Iterator;

/**
 * Composite却有个规定，那就是要在接口内部定义一个用于访问和管理Composite组合体对象的方法.
 * Created by gongchunru on 2016/10/27.
 */
public abstract class Equipment {
    private String name;

    public Equipment(String name) {
        this.name = name;
    }

    public abstract double netPrice();

    public abstract double discountPrice();

    public boolean add(Equipment equipment){
        return false;
    }

    public boolean remove(Equipment equipment){
        return false;
    }

    public Iterator iter(){
        return null;
    }

}
