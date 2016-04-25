package com.java.improve.container.set;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {

	public static void main(String[] args) {
		LinkedHashSet<String> lhset = new LinkedHashSet<String>();
		
		lhset.add("a");
		lhset.add("g");
		lhset.add("t");
		lhset.add("d");
		lhset.add("i");
		lhset.add("a");
		
		System.out.println(lhset);
		
		
	}

}
