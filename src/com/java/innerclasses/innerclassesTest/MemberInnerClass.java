package com.java.innerclasses.innerclassesTest;

/**
 * @author gongchunru
 * @Package com.java.innerclasses.innerclassesTest
 * @date 16/6/28 13:08
 */
public class MemberInnerClass {

    public int i = 0;

    private static  int j = 0;


    private final int k = 0 ;


    private static final int m = 0;

    public class PublicMemberInnerClass{
        //enclosing Class 的属性都可以访问
        public void test(){
            System.out.println(i);
            System.out.println(j);
            System.out.println(k);
            System.out.println(m);
        }

        public MemberInnerClass getOutterClass(){
            return MemberInnerClass.this;
        }
//        这里不许定义static方法.
//        private static final void test();

    }
    //私有的innerclass 外部不能访问
    private class PrivateMemberInnerClass{

    }

    //公开的局部类,外部可以访问和创建,但是只能通过OutterClass实例创建
    class DefaultMemberInnerClass{
        public MemberInnerClass getOutterClass(){
            return MemberInnerClass.this;
        }
    }

}
