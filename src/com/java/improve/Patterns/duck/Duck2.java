package com.java.improve.Patterns.duck;

/**
 * Created by gongchunru on 2016/9/6.
 */
public abstract class Duck2 {
    public void quack(){
        System.out.println("all can quack");
    };
    public void swim(){
        System.out.println("all can swim");
    };
    public abstract void display();
}
