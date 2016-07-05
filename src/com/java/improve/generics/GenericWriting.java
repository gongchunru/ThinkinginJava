package com.java.improve.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 逆变:如果一个类的父类型容器可以持有该类的子类型容器,我们称这种关系为逆变.
 * 声明方式:List<? super Integer> ,List<? super T> list
 * 不能给泛型参数给出一个超类型边界；即不能声明List<T super MyClass>。
 * @author gongchunru
 * @Package com.java.improve.generics
 * @date 16/6/1 08:12
 */
public class GenericWriting {
    static <T> void writeExact(List<T> list,T item){
        list.add(item);
    }

    static List<Apple> apples = new ArrayList<Apple>();
    static List<Fruit> fruits = new ArrayList<Fruit>();

    static void f1(){
        writeExact(apples,new Apple());
        writeExact(fruits,new Apple());
    }

    static <T> void writeWithWildcard(List<? super  T> list,T item){
        list.add(item);
    }

    static void f2(){
        writeWithWildcard(apples,new Apple());
        writeWithWildcard(fruits,new Apple());
    }


    static <T> void readWithWildcard(List<? super T> list,int index){

        //报错, required T but found Object
//        return list.get(index);

    }

    public static void main(String[] args) {
        f1();
        f2();
    }
}
