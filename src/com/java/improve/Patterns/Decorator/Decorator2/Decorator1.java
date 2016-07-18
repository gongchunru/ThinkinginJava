package com.java.improve.Patterns.Decorator.Decorator2;

/**
 * Created by 龚春如 on 2016/7/14.
 */
//这是装饰2
public class Decorator1 extends Decorator {

    public void goClothespress(){
        System.out.println("去衣柜找找..");
    }

    public void findPlaceOnMap(){
        System.out.println("在Map上找找");
    }

    public Decorator1(Human human) {
        super(human);
    }

    @Override
    public void wearClothes() {
        super.wearClothes();
        goClothespress();
    }

    @Override
    public void walkToWhere() {
        super.walkToWhere();
        findPlaceOnMap();
    }
}
