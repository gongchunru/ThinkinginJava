package com.java.innerclasses;

/**
 * 如果不需要将内部类对象与外部类对象之间有联系,那么就将内部类声明为static.这通常成为嵌套类.
 * @author gongchunru
 * @Package com.java.innerclasses
 * @date 16/6/28 10:35
 */
public class Parcel11 {
    private static class ParcelContents implements Contents{
        private int i = 11;
        @Override
        public int value() {
            return i;
        }
    }

    protected static class ParcelDestination implements Destination{
        private String label;
        private ParcelDestination(String whereTo){
            label = whereTo;
        }

        @Override
        public String readLabel() {
            return label;
        }

        //Nested classes can  other static element
        public static void f(){}
        static int x = 10;
        static class AotherLevel{
            public static void f(){}
            static int x = 10;
        }
    }
    public static Destination destination(String s){
        return new ParcelDestination(s);
    }

    public static Contents contents(){
        return new ParcelContents();
    }

    public static void main(String[] args) {
        Contents c = contents();
        Destination d = destination("Tasmania");
    }



}
