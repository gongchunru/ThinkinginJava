package com.java.chapter14.typeinfo;

import java.util.Random;

/**
 * @author gongchunru
 * @Package com.java.chapter14.typeinfo
 * @date 16/3/22 16:35
 */
class Initable{
    //static 和 final是一个编译期的常量, 不需要对其进行初始化就可以被读取.
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
    static {
        System.out.println("Initializing Initable");
    }
}
class Initable2{
    static  int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}
class Initable3{
    static  int staticNonFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }
}

public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        /*
         *初始化有效的实现了尽可能多的"惰性" ,使用class来获取对象的引用并不会引发初始化;
         * 但是,为了产生Class引用,Class.forName()立即就进行了初始化,就像在对initable3引用的创建那样
         */
        Class initable = Initable.class;

        System.out.println("After creating Initable ref");
        //Does not trigger initialization
        System.out.println(Initable.staticFinal);
        //Does trigger initialization
        System.out.println(Initable.staticFinal2);
        //Does trigger initialization
        System.out.println(Initable2.staticNonFinal);
        Class initable3 = Class.forName("com.java.chapter14.typeinfo.Initable3");
        System.out.println("After creatin Initable3 ref");
        System.out.println(Initable3.staticNonFinal);

    }
}


















