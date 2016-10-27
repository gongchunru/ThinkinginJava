package com.java.improve.Patterns.templateMethod.templateMethod3;

/**
 * Created by gongchunru on 2016/10/27.
 */
public abstract class Person {

    public void prepare(){
        dressUp();
        eatBreakFast();
        takeThings();
    }

    protected abstract void dressUp();
    protected abstract void eatBreakFast();
    protected abstract void takeThings();

}
