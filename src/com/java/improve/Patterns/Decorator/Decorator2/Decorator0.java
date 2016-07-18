package com.java.improve.Patterns.Decorator.Decorator2;

/**
 * Created by 龚春如 on 2016/7/14.
 */
//这是装饰1
public class Decorator0 extends Decorator {

    public void goHome(){
        System.out.println("进房子");
    }

    public void findMap(){
        System.out.println("书房找找map");
    }

    @Override
    public void walkToWhere() {
        super.walkToWhere();
        goHome();
    }

    @Override
    public void wearClothes() {
        super.wearClothes();
        findMap();
    }

    public Decorator0(Human human) {
        super(human);
    }
}
