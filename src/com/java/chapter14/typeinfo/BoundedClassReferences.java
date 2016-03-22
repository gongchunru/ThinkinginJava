package com.java.chapter14.typeinfo;

/**
 * @author gongchunru
 * @Package com.java.chapter14.typeinfo
 * @date 16/3/22 17:27
 */
public class BoundedClassReferences {

    //在向Class引用添加泛型语法的原因 仅仅是为了提供编译期类型检查,
    public static void main(String[] args) {
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
        //或者Number类型的任何子类
    }
}
