package com.java.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author gongchunru
 * @Package com.java.test
 * @date 16/6/24 17:24
 */
public class PatternTest {
    public static void main(String[] args) {

        String regex = "^.{1,3}$|^$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("C01");

        System.out.println(matcher.matches());
    }
}
