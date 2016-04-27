package com.java.improve.container.map;

public class HashMapIndexForTest {

	public static void main(String[] args) {
		int h = 128;
		int hashCode = 76268;
		int indexFor = hashCode & (h -1 );
		Long time1 = System.nanoTime();
		for(int i=0;i<1000;i++){
			indexFor = hashCode & (h-1);
		}
		Long time2 = System.nanoTime();
		for(int i=0;i<1000;i++){
			indexFor = h % hashCode;
		}
		Long time3 = System.nanoTime();
		System.out.println("这是与操作的时间："+(time2-time1));
	
		System.out.println(indexFor);
		System.out.println("这是取余操作的时间："+(time3-time2));
	}

}
