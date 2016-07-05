package com.java.innerclasses;

/**
 * 在匿名类中定义字段的时候,还能够对其进行初始化操作
 * @author gongchunru
 * @Package com.java.innerclasses
 * @date 16/6/27 16:49
 */
public class Parcel9 {
    //如果定义了一个匿名内部类, 并且希望它使用其中一个在其外部定义的对象,那么编译器会要求其参数引用是final的.
    public Destination destination(final String dest){
        return new Destination() {
            private String label = dest;
            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d  = p.destination("Tasmania");
    }

}
