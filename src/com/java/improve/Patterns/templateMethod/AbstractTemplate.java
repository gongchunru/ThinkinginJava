package com.java.improve.Patterns.templateMethod;

/**
 * Created by 龚春如 on 2016/7/19.
 */
public abstract class AbstractTemplate {
    //模板方法
    public void templateMethod(){

    }

    //基本方法声明
    protected abstract void abstractMethod();

    protected void hookMethod(){};

    private final void concreateMethod(){
        //业务相关的代码
    }


}
