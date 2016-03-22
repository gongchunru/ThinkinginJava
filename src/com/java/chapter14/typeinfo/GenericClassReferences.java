package com.java.chapter14.typeinfo;

/**
 * @author gongchunru
 * @Package com.java.chapter14.typeinfo
 * @date 16/3/22 17:17
 */
public class GenericClassReferences {
    public static void main(String[] args) {
        Class intClass = int.class;
        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class;//Same thing
        intClass = double.class;

//        genericIntClass = double.class; //Illegal
    }
}
