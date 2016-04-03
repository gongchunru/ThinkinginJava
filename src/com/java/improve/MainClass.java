package com.java.improve;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class MainClass {

	public static void main(String[] args) {
		//Construction An ArrayList
		ArrayList<String> listWithDuplicateElements = new ArrayList<String>();
		listWithDuplicateElements.add("JAVA");
		listWithDuplicateElements.add("J2EE");
		listWithDuplicateElements.add("JSP");
		listWithDuplicateElements.add("SERVLET");
		
		listWithDuplicateElements.add("JAVA");
		listWithDuplicateElements.add("STRUTS");
		listWithDuplicateElements.add("JSP");
		
		// Printing listWithDuplicateElements
		System.out.println("ArrayList with Duplicate Elements :");
		System.out.println(listWithDuplicateElements);
		
		
		//Constructing HashSet using listWithDuplicateElements
		HashSet<String> set = new HashSet<String>(listWithDuplicateElements);
		//Constructing listWithoutDuplicateElements using set
		ArrayList<String> listWithoutDuplicateElements = new ArrayList<String>(set);
		System.out.println("ArrayList After Removing Duplicate Elements");
		System.out.println(listWithoutDuplicateElements);
		
		
		//LinkedHashSet 
		LinkedHashSet<String> lset = new LinkedHashSet<String>(listWithDuplicateElements);
		ArrayList<String>  listWithoutDuplicateElements2 = new ArrayList<String>(lset);
		System.out.println("ArrayList After Removing Duplicate Elements");
		System.out.println(listWithoutDuplicateElements2);
	}

}
