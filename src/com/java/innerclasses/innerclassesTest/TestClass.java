package com.java.innerclasses.innerclassesTest;

/**
 * 演示static Nested Classes
 * @author gongchunru
 * @Package com.java.innerclasses.innerclassesTest
 * @date 16/6/28 11:52
 */
public class TestClass {
    public static void main(String[] args) {
        //任何地方都可以创建
        StaticNestedClass.PublicNestedClass publicNestedClass = new StaticNestedClass.PublicNestedClass();


        // 编译错误,不可访问内部类
//        StaticNestedClass.PrivateNestedClass

    }
}
