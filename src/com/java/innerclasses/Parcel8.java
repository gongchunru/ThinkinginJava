package com.java.innerclasses;

/**
 * 这里展现的是,使用有参数的构造器.
 * @author gongchunru
 * @Package com.java.innerclasses
 * @date 16/6/27 16:42
 */
public class Parcel8  {
    public Wrapping wrapping(int x ){
        return new Wrapping(x){
            public int value(){
                return super.value() * 47;
            }
        };//这里的分号表达的是表达式的结束,而不是匿名内部类的结束.
    }

    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        Wrapping w = p.wrapping(10);
    }
}
