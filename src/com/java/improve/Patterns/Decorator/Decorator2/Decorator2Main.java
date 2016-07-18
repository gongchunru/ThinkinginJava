package com.java.improve.Patterns.Decorator.Decorator2;

/**
 * Created by 龚春如 on 2016/7/14.
 */
public class Decorator2Main {
    public static void main(String[] args) {
        Human person = new Person();
        Decorator decorator = new Decorator2(new Decorator1(new Decorator0(person)));
        decorator.wearClothes();
        decorator.walkToWhere();
    }
}
