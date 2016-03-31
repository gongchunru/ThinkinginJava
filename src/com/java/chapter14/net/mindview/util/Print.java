package com.java.chapter14.net.mindview.util;

import java.io.PrintStream;

/**
 * @author gongchunru
 * @Package com.java.chapter14.net.mindview.util
 * @date 16/3/31 23:06
 */
public class Print {
    public static void print(Object obj){
        System.out.println(obj);
    }

    public static void print(){
        System.out.println();
    }

    public static void printnb(Object obj){
        System.out.println(obj);
    }

    public static PrintStream printf(String format,Object... args){
        return System.out.printf(format,args);
    }
} //
