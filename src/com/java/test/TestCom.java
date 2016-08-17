package com.java.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCom {
	public static void main(String[] args) {
//		String s = "192.168.1.202.123";
////		int s1 = s.lastIndexOf(".",4);
//		String[] s1 = s.split("^\\d+\\.\\d+\\.\\d+\\.\\d+$^[1-9].*[1-9]$");
//		System.out.println(Arrays.toString(s1));
//		System.out.println(s.substring(0,s1));

//		String s2 = "My.Class.";
//		String s3 = s2.replaceAll("\\.","/");
//		System.out.println(s3);

		List<Short> giftFlags= new ArrayList<Short>();
		Short a = 1;
		Short b = 1;
		giftFlags.add(a);
		giftFlags.add(b);

		for (int i = 0; i < giftFlags.size(); i++) {
			Short c = giftFlags.get(i);
			System.out.println(c);
		}

	}
}




