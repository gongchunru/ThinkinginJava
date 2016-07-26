package com.java.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author gongchunru
 * @Package com.java.test
 * @date 16/6/24 17:24
 */
public class PatternTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("");
        sb.append("用户名或者密码错误!");

        System.out.println(sb);

        sb.delete(0,sb.length());
        System.out.println(":"+sb);

        System.out.println("========end");
//        String regex = "^.{1,3}$|^$";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher("C01");
//
//        System.out.println(matcher.matches());



    }
}
