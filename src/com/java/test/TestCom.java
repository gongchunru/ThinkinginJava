package com.java.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCom {
	public static void main(String[] args) {
		String s = "192.168.1.202.123";
//		int s1 = s.lastIndexOf(".",4);
		String[] s1 = s.split("^\\d+\\.\\d+\\.\\d+\\.\\d+$^[1-9].*[1-9]$");
		System.out.println(Arrays.toString(s1));
//		System.out.println(s.substring(0,s1));

	}
}




