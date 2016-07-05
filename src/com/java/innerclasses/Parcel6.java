package com.java.innerclasses;

/**
 * 在任意的作用域内嵌入一个内部类
 * @author gongchunru
 * @Package com.java.innerclasses
 * @date 16/6/27 16:27
 */
public class Parcel6 {
    private void internalTracking(boolean b){
        if (b){
            class TrackingSlip{//在定义TrackingSlip 之外,它是不可用的,除此之外,它与普通类一样.
                private String id;
                TrackingSlip(String s){
                    id = s;
                }
                String getSlip(){return id;}
            }
            TrackingSlip ts = new TrackingSlip("slip");
            String s = ts.getSlip();
        }
        //这里不能使用
//        TrackingSlip ts = new TrackingSlip("x");
    }
    public void Track(){internalTracking(true);}
    public static void main(String[] args) {
        Parcel6 p = new Parcel6();
        p.Track();
    }
}
