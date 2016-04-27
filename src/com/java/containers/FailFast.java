package com.java.containers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 *  这是快速报错机制，是Java容器的一种保护机制，能够防止多个进程同时修改一个容器的内存。
 *  
 *  程序运行时出现了异常，因为容器在取得迭代器之后，又有东西被放入了该容器中。当程序的不同部分修改同一个容器时，
 *  就可能导致容器的状态不一致。所以，应该在添加完元素之后，在获取迭代器。
 *  
 *  其中ConcurrentHashMap ,CopyOnWriteArrayList, CopyOnWriteArraySet 
 *  都使用了ConcurrentModificationException技术
 * @author gongchunru
 *
 */
public class FailFast {
	
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		Iterator<String> it = c.iterator();
		c.add("An Object");
		
		try {
			String s = it.next();
		} catch (ConcurrentModificationException e) {
			System.out.println(e);
		}
		
	}

}
