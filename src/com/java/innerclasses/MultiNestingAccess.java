package com.java.innerclasses;

/**
 * 一个内部类被嵌套多少层并不重要,它能透明地访问所有它所嵌入的外围类的所有成员
 * @author gongchunru
 * @Package com.java.innerclasses
 * @date 16/6/28 16:39
 */
class MNA{
    private void f(){}
    class A{
        private void g(){}
        public class B{
            void h(){
                g();
                f();
            }
        }
    }
}

public class MultiNestingAccess {
    public static void main(String[] args) {
        MNA mna = new MNA();
        MNA.A mnaa = mna.new A();
        MNA.A.B mnaab = mnaa.new B();
        mnaab.h();
    }
}
