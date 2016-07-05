package com.java.strings;

import java.io.PrintStream;
import java.util.Formatter;

/**
 * @author gongchunru
 * @Package com.java.strings
 * @date 16/6/26 19:21
 */
public class Turtle {
    private String name;
    private Formatter f;

    public Turtle(Formatter f, String name) {
        this.f = f;
        this.name = name;
    }

    public void move(int x,int y){
        f.format("%s The turtle is at (%d %d)\n",name,x,y);
    }



    public static void main(String[] args) {

//        PrintStream outAlias = System.out;
        PrintStream outAlias = System.err;
        Turtle terry = new Turtle(new Formatter(outAlias),"terry");
//        Turtle tommy = new Turtle(new Formatter(System.out),"tommy");
        Turtle tommy = new Turtle(new Formatter(System.err),"tommy");

        tommy.move(0,0);
        terry.move(2,5);
        tommy.move(4,6);
        tommy.move(3,4);

    }
}
