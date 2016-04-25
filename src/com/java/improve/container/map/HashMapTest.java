package com.java.improve.container.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
	public static void main(String[] args) {
		//HashMap中的默认数组大小是16*0.75=12，如果put的大小超过了默认大小，又没有指定大小，
		Long begin1 = System.currentTimeMillis();
		System.out.println(begin1);
		for (int i = 0; i < 100000; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("a", 1);
			map.put("b", 2);
			map.put("c", 3);
			map.put("d", 4);
			map.put("e", 5);
			map.put("f", 6);
			map.put("g", 7);
			map.put("h", 8);
			map.put("i", 9);
			map.put("j", 10);
			map.put("k", 11);
			map.put("l", 12);
			map.put("m", 13);
			map.put("n", 14);
			map.put("o", 15);
			
		}
		Long begin2 = System.currentTimeMillis();
		System.out.println(begin2-begin1);
		
	}
	
}
