package com.java.improve.container.list;

import static com.java.chapter14.net.mindview.util.Print.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
* @Description: ArrayList遍历方式和效率的测试
* @author gongchunru
* @date 2016年4月23日 下午4:09:47
 */
public class ListForArrayListEfficiencyTest {

	public static void main(String[] args) {
		List list = new ArrayList();
		for (int i = 0; i < 5000000; i++) {
			list.add(i);
		}
		randomAccess(list);
		iterator(list);
		iteratorFor2(list);
	}

	public static void randomAccess(List list){
		long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
			list.get(i);
		}
        endTime = System.currentTimeMillis();
        Long interval = endTime-startTime;
        print("randomAccess: "+interval);
	}
	public static void iterator(List list){
		long startTime;
		long endTime;
		startTime = System.currentTimeMillis();
		for (Iterator iter = list.iterator();iter.hasNext();) {
			iter.next();
		}
		endTime = System.currentTimeMillis();
		Long interval = endTime-startTime;
		print("iterator: "+interval);
	}
	public static void iteratorFor2(List list){
		long startTime;
		long endTime;
		startTime = System.currentTimeMillis();
		for (Object list2:list){}
		endTime = System.currentTimeMillis();
		Long interval = endTime-startTime;
		print("iteratorFor2: "+interval);
	}
}
