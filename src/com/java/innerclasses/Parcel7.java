package com.java.innerclasses;

/**
 * @author gongchunru
 * @Package com.java.innerclasses
 * @date 16/6/27 16:34
 */
public class Parcel7 {
    public Contents contents(){
        return new Contents() {//创建一个继承自Contents的匿名类的对象. 通过new关键字创建的引用被默认像上转型为Contents的引用
            private int i = 11;
            @Override
            public int value() {
                return i;
            }
        };
    }

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents c = p.contents();
    }
}
