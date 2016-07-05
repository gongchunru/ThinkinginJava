package com.java.improve.generics;

import java.lang.reflect.Array;

/**
 * 一般不建议使用范型数组,但是还是给出一个使用范型数组的方法.
 * @author gongchunru
 * @Package com.java.improve.generics
 * @date 16/5/31 17:20
 */
public class GenericArrayWithTypeToken<T> {
    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArrayWithTypeToken(Class<T> type,int sz){
        array = (T[]) Array.newInstance(type,sz);
    }

    public void put(int index,T item){
        array[index] = item;
    }

    public T[] rep(){
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> gai = new GenericArrayWithTypeToken<Integer>(Integer.class,10);
        Integer[] ia = gai.rep();
    }

}
