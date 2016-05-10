package com.java.improve.container.queue;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.PriorityQueue;
/**
 * 优先队列 可以按照任意的顺序插入，但是检索的时候是按照顺序进行检索的。无论何时调用remove方法，总是从最小的元素开始删除。
 * 但是，优先级队列，并没有对所有的元素进行排序。
 * 优先级队列使用的数据结构是：堆。
 * 
 * 这里的迭代顺序并不是按照元素的顺序进行访问的，但是删除的元素总是从最小的元素开始删除的。
 * 
* @Description: TODO
* @author gongchunru
* @date 2016年5月6日 下午5:35:58
 */
public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue<GregorianCalendar> pq = new PriorityQueue<GregorianCalendar>();
		pq.add(new GregorianCalendar(1906, Calendar.DECEMBER, 9));
		pq.add(new GregorianCalendar(1815,Calendar.DECEMBER,10));
		pq.add(new GregorianCalendar(1903,Calendar.DECEMBER,3));
		pq.add(new GregorianCalendar(1910, Calendar.JUNE, 22));
		
		System.out.println("遍历元素");
		for(GregorianCalendar date:pq){
			System.out.println(date.get(Calendar.YEAR));
		}
		
		System.out.println("删除元素");
		while(!pq.isEmpty()){
			System.out.println(pq.remove().get(Calendar.YEAR));
		}
		
		
	}

}
