package com.java.innerclasses;

/**
 * @author gongchunru
 * @Package com.java.innerclasses
 * @date 16/6/27 16:37
 */
public class Parcle7b {

    class MyContents implements Contents{
        private int i  = 11;
        @Override
        public int value() {
            return i;
        }
    }

    public Contents contents(){return new MyContents();}

    public static void main(String[] args) {
        Parcel7 p  =  new Parcel7();
        Contents c = p.contents();
    }
}
