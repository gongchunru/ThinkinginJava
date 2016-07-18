package com.java.improve.Patterns.Decorator.Decorator2;

/**
 * Created by 龚春如 on 2016/7/14.
 */
//这是装饰3
public class Decorator2 extends Decorator {


    public Decorator2(Human human) {
        super(human);
    }

    public void findClothes(){
        System.out.println("找到一件Nike");
    }

    public void findTheTarget(){
        System.out.println("在Map上找到神秘花园和城堡。");
    }

    @Override
    public void wearClothes() {
        super.wearClothes();
        findClothes();
    }

    @Override
    public void walkToWhere() {
        super.walkToWhere();
        findTheTarget();
    }
}
