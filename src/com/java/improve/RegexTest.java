package com.java.improve;

public class RegexTest {
	public static void main(String[] args) {
        String s = "newDealer";
        String[] ss = s.split("(?<!^)(?=[A-Z])");
        StringBuilder sort = new StringBuilder("");
        for(int i = 0 ;i < ss.length; i ++){
        	sort.append(ss[i]);
        	sort.append("_");
        }
        sort.delete(sort.length()-1, sort.length());
        System.out.println(sort.toString().toUpperCase());
    }
}
