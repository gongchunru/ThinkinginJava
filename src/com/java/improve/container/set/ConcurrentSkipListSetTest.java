package com.java.improve.container.set;

import java.util.Comparator;
import java.util.concurrent.ConcurrentSkipListSet;

public class ConcurrentSkipListSetTest {

	public static void main(String[] args) {
		ConcurrentSkipListSet<Integer> set = new ConcurrentSkipListSet<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		set.add(1);
		set.add(10);
		set.add(2);
		set.add(8);
		set.add(3);
		
		System.out.println(set);
	}

}
