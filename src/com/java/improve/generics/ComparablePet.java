package com.java.improve.generics;

/**
 * 父类中我们为Comparable确定了ComparablePet参数,那么其他任何类型都不能再与ComparablePet之外的类型对象比较.
 * 子类中不能对同一个接口用不同的参数实现两次.这有点类似于重载
 * 但是我们可以在子类中覆写父类的方法.
 * @author gongchunru
 * @Package com.java.improve.generics
 * @date 16/6/1 09:37
 */
public class ComparablePet implements Comparable<ComparablePet> {
    @Override
    public int compareTo(ComparablePet o) {
        return 0;
    }
}

class Cat extends ComparablePet implements Comparable<ComparablePet>{

    public int compareTo(ComparablePet arg){
        return 0;
    };
//    public int compareTo(ComparablePet arg);
}