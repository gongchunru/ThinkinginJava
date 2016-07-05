package com.java.innerclasses.innerclassesTest;

/**
 * @author gongchunru
 * @Package com.java.innerclasses.innerclassesTest
 * @date 16/6/28 13:28
 */
public class LocalInnerClass {
    //私有局部
    private int i = 0;

    //静态
    public static int j = 0 ;

    //不变值
    private final int k = 0;

    //static final
    private static final int m = 0;

    public static void test(){
        final int a = 0;
        int b = 0;
        //local inner class 不能够有访问控制符比如:public ,private
        abstract class LocalStaticInnerClass{
//            local inner class 不能定义静态属性
//            private static  int c;
            private int d = 0;
            public LocalStaticInnerClass(){
                //可以访问方法里面定义的final变量
                System.out.println(a);
                //不能访问b 因为b不是final
//                System.out.println(b);
//                定义在static上下文里面的local inner class 不能访问外部类的非static字段
//                System.out.println(k);
//                System.out.println(i);
                System.out.println(j);
                System.out.println(m);
            }
//            local inner class不能定义静态方法
//            public static void test(){}
        }
    }

    public void test2(){
        final int a = 0;
        int b = 0;
        final class LocalNonStaticInnerClass{
            public LocalNonStaticInnerClass(){
                //定义在非static上下文的local inner class 可以访问外部类的所有属性
                System.out.println(i);
                System.out.println(k);
                System.out.println(j);
                System.out.println(m);
            }
        }
    }

}
