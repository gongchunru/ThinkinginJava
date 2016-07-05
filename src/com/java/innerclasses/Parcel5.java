package com.java.innerclasses;

/**
 * 在方法的作用域内,创建一个完整的类.被称为局部内部类
 * @author gongchunru
 * @Package com.java.innerclasses
 * @date 16/6/27 16:15
 */
public class Parcel5 {
    public Destination destination(String s){
        class PDestination implements Destination{
            private String label;
            public PDestination(String whereTo) {
                label = whereTo;
            }
            @Override
            public String readLabel() {
                return label;
            }
        }
        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        Destination d = p.destination("Tasmania");
    }
}
