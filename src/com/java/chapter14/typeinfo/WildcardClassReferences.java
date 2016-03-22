package com.java.chapter14.typeinfo;

/**
 * @author gongchunru
 * @Package com.java.chapter14.typeinfo
 * @date 16/3/22 17:24
 */
public class WildcardClassReferences {
    public static void main(String[] args) {
        Class<?> intClass = int.class;
        intClass = double.class;
    }
}
