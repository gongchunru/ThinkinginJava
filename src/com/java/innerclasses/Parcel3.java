package com.java.innerclasses;

/**
 * 拥有外部类对象之前是不可能创建内部类对象的. 这是因为内部类对象会暗暗的连接到创建它的外部类对象上.
 * @author gongchunru
 * @Package com.java.innerclasses
 * @date 16/6/27 09:57
 */
public class Parcel3 {
    class Contents{
        private int i = 11;
        public int value(){return  i;}
    }
    class Destination{
        private String label;
        Destination(String whereTo){label = whereTo;}
        String readLabel(){return label;}
    }

    public static void main(String[] args) {
        Parcel3 p = new Parcel3();
        Parcel3.Contents  c = p.new Contents();
        Parcel3.Destination d = p.new Destination("Tasmania");
    }

}
