package com.java.chapter14.typeinfo;

/**
 * @author gongchunru
 * @Package com.java.chapter14.typeinfo
 * @date 16/3/23 11:45
 */
class Building{}
class House extends Building{}

public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseType = House.class;
        House h = houseType.cast(b);
        h = (House) b;//or just do this
    }
}
