package com.java.containers;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 使用特定的set实现类型而必须定义的方法
 * @author gongchunru
 * @Package com.java.containers
 * @date 16/5/31 00:14
 */
class SetType{
    int i;
    public  SetType(int n){i=n;}
    public boolean equals(Object o){
        return o instanceof SetType && (i == ((SetType) o).i);
    }

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}

class HashType extends SetType{
    public HashType(int n){super(n);}
    public int hashCode(){return i;}
}

class TreeType extends SetType implements  Comparable<TreeType>{
    public TreeType(int n){super(n);}

    @Override
    public int compareTo(TreeType o) {
        return (o.i<i ? -1:(o.i == i)? 0:1);
    }
}


public class TypesForSets {
    static <T> Set<T> fill(Set<T> set,Class<T> type){
        try {
            for (int i=0;i<10;i++)
                set.add(type.getConstructor(int.class).newInstance(i));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return set;
    }
    static <T> void test(Set<T> set,Class<T> type){
        fill(set,type);
        fill(set,type);
        fill(set,type);
        System.out.println("aaaa"+set);
    }

    public static void main(String[] args) {
//        test(new HashSet<HashType>(),HashType.class);
//        test(new LinkedHashSet<HashType>(),HashType.class);
//        test(new TreeSet<TreeType>(),TreeType.class);

        test(new HashSet<SetType>(),SetType.class);
        test(new HashSet<TreeType>(),TreeType.class);
        test(new LinkedHashSet<SetType>(),SetType.class);
        test(new LinkedHashSet<TreeType>(),TreeType.class);

        try {
            test(new TreeSet<HashType>(),HashType.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            test(new TreeSet<LinkedHashSet>(),LinkedHashSet.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}



