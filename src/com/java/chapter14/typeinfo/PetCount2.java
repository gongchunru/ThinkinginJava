package com.java.chapter14.typeinfo;

import com.java.chapter14.typeinfo.pets.PetCount;
import com.java.chapter14.typeinfo.pets.Pets;

/**
 * @author gongchunru
 * @Package com.java.chapter14.typeinfo
 * @date 16/3/25 00:00
 */
public class PetCount2 {
    public static void main(String[] args) {
        PetCount.countPets(Pets.creator);
    }
}
