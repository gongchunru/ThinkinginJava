package com.java.improve.Patterns.Decorator;

/**
 * Created by 龚春如 on 2016/7/14.
 */
//这个类是装饰的抽象类
public abstract class Decorator extends Face {

    protected Face face;

    public void setFace(Face face) {
        this.face = face;
    }

    @Override
    public void show() {
        if (face!=null){
            face.show();
        }
    }
}
