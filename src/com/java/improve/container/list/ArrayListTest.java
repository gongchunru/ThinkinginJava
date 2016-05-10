package com.java.improve.container.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class ArrayListTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		
		list.remove(2);
		
		ListIterator<String> litr = list.listIterator();
		while(litr.hasNext()){
			System.out.println(litr.nextIndex()+":"+litr.next());
		}
		
		List list2 = new ArrayList();
		list2.add("1");
		list2.add(123);
		list2.add(true);
		
		
		
	}

}
