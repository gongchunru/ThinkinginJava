package com.java.improve.generics;

/**
 * 范型参数的类型无法使用instanceof关键字来做判断,所以使用类类型来构造一个类型判断器.
 * 判断一个实例是否是某一个类型
 * @author gongchunru
 * @Package com.java.improve.generics
 * @date 16/5/31 15:49
 */
class Building{}
class House extends Building{}

public class ClassTypeCapture<T> {
    Class<T> kind;

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object arg){
        return kind.isInstance(arg);
    }
    public static void main(String[] args) {
        ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<Building>(Building.class);
        System.out.println(ctt1.f(new Building()));//true  Building isInstance Building
        System.out.println(ctt1.f(new House()));//true  Building isInstance House
        ClassTypeCapture<House> ctt2 = new ClassTypeCapture<House>(House.class);
        System.out.println(ctt2.f(new Building()));//false House isInstance Building
        System.out.println(ctt2.f(new House()));//true Building isInstance House
    }

}
