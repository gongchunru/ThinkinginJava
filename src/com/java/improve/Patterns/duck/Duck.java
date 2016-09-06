package com.java.improve.Patterns.duck;

/**
 * @author gongchunru
 * @Package com.java.improve.Patterns.duck
 * @date 16/9/6 08:01
 */
public abstract class Duck  {

    FlyBehavior flyBehavior;

    QuackBehavior quackBehavior;

    public Duck(){}

    public abstract void display();

    public void performFly(){
        flyBehavior.fly();//委托给行为类
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public void swim(){
        System.out.println("All Ducks float,even decoys!");
    }

}
