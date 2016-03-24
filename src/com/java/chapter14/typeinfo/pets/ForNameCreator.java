package com.java.chapter14.typeinfo.pets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gongchunru
 * @Package com.java.chapter14.typeinfo.pets
 * @date 16/3/23 23:30
 */
public class ForNameCreator extends PetCreator{
    private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();

    private static String[] typeNames = {
            "com.java.chapter14.typeinfo.pets.Mutt",
            "com.java.chapter14.typeinfo.pets.Pug",
            "com.java.chapter14.typeinfo.pets.EgyptianMau",
            "com.java.chapter14.typeinfo.pets.Manx",
            "com.java.chapter14.typeinfo.pets.Cymric",
            "com.java.chapter14.typeinfo.pets.Rat",
            "com.java.chapter14.typeinfo.pets.Mouse",
            "com.java.chapter14.typeinfo.pets.Hamster"
    };

    /**
     * 为了产生具有实际类型的Class对象的List,必须使用转型,这会产生编译期警告.
     */
    @SuppressWarnings("unchecked")
    private static void loader(){
        try {
            for (String name : typeNames)
                types.add((Class<? extends  Pet>)Class.forName(name));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * loaer()方法被单独的置于static块中, 因为@SuppressWarnings() 不能直接置于静态初始化字句之上.
     */
    static{
        loader();
    }

    public List<Class<? extends Pet>> types(){
        return types;
    }



}
