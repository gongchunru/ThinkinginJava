package com.java.innerclasses.innerclassesTest;

/**
 * Static Nested Classes访问规则
 * 用Static修饰的Nested Classes，只能访问外部类的非static变量。
 * 对于public 的 static Nested Classes 可以用 new 外部类.内部类()的方式直接创建
 * 而默认的static Nested Classes 可以在同一包名下，用 new 外部类.内部类()的方式创建
 * 静态成员类可以使用访问控制符，可以使用static修饰，可以是abstract抽象类
 *
 * 在大多数情况下，一般把nested classes 分为两种：

    1. Static Nested Classes（静态嵌套类）: 就是用static修饰的成员嵌套类
    2. InnerClass：静态嵌套类之外所有的嵌套类的总称,也就是没有用static定义的nested classes，
        Inner Classes 不能定义为static，不能有static方法和static初始化语句块。
 * @author gongchunru
 * @Package com.java.innerclasses.innerclassesTest
 * @date 16/6/28 11:16
 */
public class StaticNestedClass {
    //静态成员
    private int i = 0;

    //静态
    public static int j = 0;

    //不变值
    private final int k = 0;

    //static final
    private static final int m = 0;

    //静态嵌套类,这里不是innerclass,可以直接new出来
    public static class PublicNestedClass{
        private void test1(){
//            System.out.println(i); //非innerClass 不能访问enclosing类的非static属性
            System.out.println(j);
            System.out.println(m);
//            System.out.println(k); //非innerClass不能访问enclosing 类的非static属性.
        }
        //可以定义static方法
        private static void test2(){

        }
    }
    //静态嵌套类,这里不是innerclass,由于是私有的,不可以直接new出来.
    private static class PrivateNestedClass{

    }
}
