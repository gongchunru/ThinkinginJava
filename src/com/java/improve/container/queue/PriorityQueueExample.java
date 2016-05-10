package com.java.improve.container.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class PriorityQueueExample {
	public static void main(String[] args) {
		
		
		
		//优先队列自然排序
		Queue<Integer> integerPriorityQueue = new PriorityQueue<Integer>();
		Random rand = new Random();
		for(int i=0;i<7;i++){
			integerPriorityQueue.add(new Integer(rand.nextInt(100)));
		}
		for(int i=0;i<7;i++){
			Integer in = integerPriorityQueue.poll();
			System.out.println("  "+in);
		}
		//优先使用队列
		Queue<Customer> customerPriorityQueue = new PriorityQueue<Customer>(7,idComparator);
		addDataToQueue(customerPriorityQueue);;
		pollDataFromQueue(customerPriorityQueue);
	}
	
	public static Comparator<Customer> idComparator =  new Comparator<Customer>() {

		@Override
		public int compare(Customer o1, Customer o2) {
			return (int)(o1.getId() - o2.getId());
		}
	};
	
	private static void addDataToQueue(Queue<Customer> customerPriorityQueue){
		Random rand = new Random();
		for(int i=0;i<7;i++){
			int id = rand.nextInt(100);
			customerPriorityQueue.add(new Customer(id, "Carol "+id));
		}
	}
	
	private static void pollDataFromQueue(Queue<Customer> customerPriorityQueue){
		while(true){
			Customer cust = customerPriorityQueue.poll();
			if(cust == null ) break;
			System.out.println(" id "+cust.getId());
		}
	}
	
}
