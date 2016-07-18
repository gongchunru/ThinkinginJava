package com.java.improve.Patterns.noChange;

/**
 * Created by 龚春如 on 2016/7/18.
 */
//不变模式
public final class Product {
    //确保无子类
    private final String no;
    //私有属性
    private final String name;

    private final double price;

    public Product(String no, String name, double price) {//必须有构造器，在创建对象的时候必须指定数据，因为创建之后，无法修改。
        super();
        this.no = no;
        this.name = name;
        this.price = price;
    }

    public String getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
