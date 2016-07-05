package com.java.innerclasses.innerclassesTest;

/**
 * 一般把定义内部类的外围类称为包装类（enclosing class)或者外部类
 * 嵌套类:
 *  1. member nested class（成员嵌套类） ：成员嵌套类 作为 enclosing class 的成员定义的，成员嵌套类有enclosing class属性

    2. local nested class （局部嵌套类）: 局部嵌套类定义在 enclosing class 的方法里面，局部嵌套类有enclosing class 属性和enclosing method 属性

    3. anonymous nested class（匿名嵌套类）：匿名嵌套类没有显示的定义一个类，直接通过new 的方法创建类的实例。一般回调模式情况下使用的比较多
 *
 * @author gongchunru
 * @Package com.java.innerclasses.innerclassesTest
 * @date 16/6/28 11:08
 */
public class EnclosingClass {
    public static final class NestedMemberClass{

    }

    public void nestedLocalClass(){
        //局部嵌套类,定义在方法里边
        final class NestedLocalClass{

        }
    }

    public void nestedAnonymousClass() {
        new Runnable(){
            @Override
            public void run() {

            }
        };
    }
}
