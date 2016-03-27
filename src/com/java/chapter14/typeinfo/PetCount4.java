package com.java.chapter14.typeinfo;

import com.java.chapter14.net.mindview.util.TypeCounter;
import com.java.chapter14.typeinfo.pets.Pet;
import com.java.chapter14.typeinfo.pets.Pets;

/**
 * @author gongchunru
 * @Package com.java.chapter14.typeinfo
 * @date 16/3/26 14:27
 */
public class PetCount4 {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Pet.class);
        for (Pet pet: Pets.createArray(20)){
            System.out.println(pet.getClass().getSimpleName()+"");
            counter.count(pet);
        }
        System.out.println();
        System.out.println(counter);
    }
}
