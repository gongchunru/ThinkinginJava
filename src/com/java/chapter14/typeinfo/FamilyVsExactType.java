package com.java.chapter14.typeinfo;

/**
 * @author gongchunru
 * @Package com.java.chapter14.typeinfo
 * @date 16/3/31 23:05
 */


/*
instanceof代表的是"你是这个类吗?或者你是这个类的子类/派生类吗?"
而equals和==比较的是两个对象,没有考虑继承或者确切的类型,或者不是.
 */
import static com.java.chapter14.net.mindview.util.Print.*;
class Base{}
class Derived extends Base{}

public class FamilyVsExactType  extends Base {

    static void test(Object x){
        print("Testing x of Type"+x.getClass());
        print("x instanceof Base"+(x instanceof Base));
        print("x instanceof Derived "+ (x instanceof Derived));
        print("Base.isInstance(x) " + (Base.class.isInstance(x)));
        print("Derived.isInstance(x) " + (Derived.class.isInstance(x)));
        print("x.getClass() == Base.class" + (x.getClass() == Base.class));
        print("x.getClass() == Derived.class"+(x.getClass() == Derived.class));
        print("x.getClass().equals(Base.class)"+(x.getClass().equals(Base.class)));
        print("x.getClass().equals(Derived.class"+(x.getClass().equals(Derived.class)));
    }

    public static void main(String[] args) {
        test(new Base());
        test(new Derived());
    }
}
