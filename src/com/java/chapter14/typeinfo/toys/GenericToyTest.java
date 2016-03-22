package com.java.chapter14.typeinfo.toys;

/**
 * @author gongchunru
 * @Package com.java.chapter14.typeinfo.toys
 * @date 16/3/22 18:15
 */
public class GenericToyTest {
    public static void main(String[] args) throws Exception {
        Class<FancyToy> ftClass = FancyToy.class;
        //Products exact type;
        FancyToy fancyToy = ftClass.newInstance();
        Class<? super FancyToy> up = ftClass.getSuperclass();
        //This won't compile;
        //Class<Toy> up2 = ftClass.getSuperclass();
        //only produces object;
        Object obj = up.newInstance();
    }
}
