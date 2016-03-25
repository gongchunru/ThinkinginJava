package com.java.chapter14.typeinfo.pets;

import java.util.ArrayList;

/**
 * @author gongchunru
 * @Package com.java.chapter14.typeinfo.pets
 * @date 16/3/24 23:54
 */
public class Pets {
    public static final PetCreator creator = new LiteralPetCreator();

    public static Pet randomPet(){
        return creator.randomPet();
    }

    public static Pet[] createArray(int size){
        return creator.createArray(size);
    }

    public static ArrayList<Pet> arrayList(int size){
        return creator.arrayList(size);
    }
}
