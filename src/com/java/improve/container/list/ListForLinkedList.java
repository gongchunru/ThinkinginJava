package com.java.improve.container.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class ListForLinkedList {
	public static void main(String[] args) {
		List<String> a = new LinkedList<String>();
		a.add("Amy");
		a.add("Carl");
		a.add("Erica");
		
		List<String> b = new LinkedList<String>();
		b.add("Bob");
		b.add("Doug");
		b.add("Frances");
		b.add("Gloria");
		
		
		//merge the words from b into a
		ListIterator<String> aIter = a.listIterator();
		Iterator<String> bIter = b.iterator();
		System.out.println(bIter.next());
		while (bIter.hasNext()) {
			if (aIter.hasNext()) {
				aIter.next();
			}
			aIter.add(bIter.next());
		}
		
		System.out.println(a);
		
		//remove every second word from b
		bIter = b.iterator();
		while (bIter.hasNext()) {
			bIter.next();
			if (bIter.hasNext()) {
				bIter.next();
				bIter.remove();
			}
		}
		System.out.println(b);
		
		a.removeAll(b);
		
		System.out.println(a);
		
	}
}
