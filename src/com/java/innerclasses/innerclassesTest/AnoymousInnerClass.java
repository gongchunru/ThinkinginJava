package com.java.innerclasses.innerclassesTest;

/**
 * anonymous inner classes(匿名类)也是定义在方法里的,匿名类和局部类访问规则一样，只不过内部类显式的定义了一个类，然后通过new的方式创建这个局部类实例，
 * 而匿名类直接new一个类实例，没有定义这个类。
 * 匿名类最常见的方式就是回调模式的使用，通过默认实现一个接口创建一个匿名类然后，然后new这个匿名类的实例。
 * @author gongchunru
 * @Package com.java.innerclasses.innerclassesTest
 * @date 16/6/28 14:34
 */
public class AnoymousInnerClass {
    //访问规则和局部类一样
    public void test(){
        //匿名类实现
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        //非匿名类实现
        class NoneAnonymousInnerClass{
            public void run(){

            }
        }

        NoneAnonymousInnerClass t = new NoneAnonymousInnerClass();
//        new Thread(t).start();

    }



}
