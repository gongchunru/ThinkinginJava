package com.java.innerclasses;

import sun.security.krb5.internal.crypto.Des;

/**
 * @author gongchunru
 * @Package com.java.innerclasses
 * @date 16/6/16 15:19
 */
public class Parcell {
   class Contents {
       private int i = 11;
       public int value(){return i;}
   }

    class Destination{
        private String label;
        Destination(String whereTo){
            label = whereTo;
        }
        String readLabel(){return label;}
    }

    public void ship(String dest){
        Contents c = new Contents();
        Destination d = new Destination(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        Parcell p = new Parcell();
        p.ship("Tasmania");
    }

}
