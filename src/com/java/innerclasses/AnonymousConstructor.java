package com.java.innerclasses;

/**
 * 通过 实例初始化,为匿名内部类创建一个构造器的效果
 * @author gongchunru
 * @Package com.java.innerclasses
 * @date 16/6/27 16:57
 */

abstract class Base{
    public Base(int i) {
        System.out.printf("Base constructor, i = "+i);
    }
    public abstract void f();
}

public class AnonymousConstructor {
    public static Base getBase(int i){//这里不要求i为final,因为不会直接在内部类中使用,传递给了基类的构造器,
        return new Base(i) {
            {

                System.out.println("Inside instance initalizer");
            }
            @Override
            public void f() {
                System.out.println("In anonymous f()");
            }
        };
    }

    public static void main(String[] args) {
        Base base = getBase(47);
        base.f();
    }


}
