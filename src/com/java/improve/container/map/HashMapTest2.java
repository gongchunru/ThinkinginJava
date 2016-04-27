package com.java.improve.container.map;

public class HashMapTest2 {

	public static void main(String[] args) {
		int capacity = 3;
		int initialCapacity = 16;
		while(capacity < initialCapacity){
			capacity <<=1;
		}
		System.out.print(capacity);
	}

}
