package com.java.improve.Patterns.Decorator;

/**
 * Created by 龚春如 on 2016/7/14.
 */
//画粉底
public class FenDiDecorator extends Decorator{

    @Override
    public void show() {
        //先执行父类的职责
        super.show();
        System.out.println("with fendi");
    }
}
