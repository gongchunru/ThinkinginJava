package com.java.chapter14.typeinfo.toys;

/**
 * @author gongchunru
 * @Package com.java.chapter14.typeinfo.toys
 * @date 16/3/22 14:58
 */

interface HasBatteries{}
interface Waterproof{}
interface Shoots{}


class  Toy{
    Toy(){}
    Toy(int i){}
}

class FancyToy extends  Toy implements HasBatteries,Waterproof,Shoots{
    FancyToy(){super(1);}
}


public class ToyTest {

    static void printInfo(Class cc){
        System.out.println("Class name:"+cc.getName() +
            " is interface ? [" + cc.isInterface() + " ]");
        System.out.println("simple name : "+ cc.getSimpleName());
        System.out.println("Canonical name: "+ cc.getCanonicalName());

    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("com.java.chapter14.typeinfo.toys.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Cant't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for (Class face : c.getInterfaces()){
            printInfo(face);
        }
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            //Requires default construct
            //使用该语句必须使用默认的构造器
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Cannot instance");
            System.exit(1);
        } catch (IllegalAccessException e){
            System.out.println("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }


}


