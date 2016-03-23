package com.java.chapter14.typeinfo.pets;

import java.util.Comparator;

/**
 * @author gongchunru
 * @Package com.java.chapter14.typeinfo.pets
 * @date 16/3/23 16:34
 *
 *
 */
public class Individual implements Comparable<Individual>{

    private static long counter = 0;
    private final long id = counter++;
    private String name;
    public Individual(){}
    public Individual(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + (name ==null ? "" : "" + name);
    }

    public long id(){return id;}
    public boolean equals(Object o){
        return o instanceof Individual && id == ((Individual)o).id;
    }

    @Override
    public int hashCode() {
        int result = 17;
        if (name !=null)
            result = 37 * result + name.hashCode();
        result = 37 * result + (int)id;
        return result;
    }

    @Override
    public int compareTo(Individual args) {
        //Compare by class name first;
        String first = getClass().getSimpleName();
        String argFirst = args.getClass().getSimpleName();
        int firstCompare = first.compareTo(argFirst);
        if(firstCompare !=0)
            return firstCompare;
        if (name!=null && args.name !=null){
            int secondCompare = name.compareTo(args.name);
            if (secondCompare !=0)
                return secondCompare;
        }
        return (args.id < id ? -1 : (args.id == id ? 0 : 1));
    }
}
