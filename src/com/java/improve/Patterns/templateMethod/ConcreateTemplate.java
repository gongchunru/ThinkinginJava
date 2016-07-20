package com.java.improve.Patterns.templateMethod;

/**
 * Created by 龚春如 on 2016/7/19.
 */
public class ConcreateTemplate extends AbstractTemplate {
    @Override
    protected void abstractMethod() {
        System.out.println("。。。");
    }

    @Override
    protected void hookMethod() {
        super.hookMethod();
        System.out.println("重写了父类的方法");
    }
}
