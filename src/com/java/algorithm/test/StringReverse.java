package com.java.algorithm.test;

import java.util.Arrays;

/**
 * @author gongchunru
 * @Package com.java.algorithm.test
 * @date 2016/11/11 20:28
 */
public class StringReverse {

    public static void main(String[] args) {
        String str = "hello world";
        System.out.println("原始字符串:");
        System.out.print(str);

        System.out.println();
        reverse1(str);


        System.out.println();
        reverse2(str);
        System.out.println();

        reverse3(str);
    }

    public static void reverse1(String str){
        char[] c = str.toCharArray();
        char[] b = new char[c.length];
        for (int i = 0;i<c.length;i++){
            b[i] = c[c.length-i-1];
            System.out.print(b[i]);
        }
        System.out.println();
        System.out.println(Arrays.toString(b));
    }

    public static void reverse2(String str){
        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb.reverse().toString());
    }

    public static void reverse3(String str){
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(str.length()-1-i);
            System.out.print(c);
        }
    }
}
