package com.java.improve.container.map;

import java.util.HashMap;
/**
 * 模拟一下hashmap的循环
* @Description: TODO
* @author gongchunru
* @date 2016年5月9日 上午7:23:51
 */
public class HashMapInfiniteLoop {

	private HashMap hash = new HashMap();
	
    public HashMapInfiniteLoop() {  
        Thread t1 = new Thread() {  
            public void run() {  
                for (int i = 0; i < 50000; i++) {  
                    hash.put(new Integer(i), Integer.valueOf(i));  
                }  
                System.out.println("t1 over");  
            }  
        };  
        Thread t2 = new Thread() {  
            public void run() {  
                for (int i = 0; i < 50000; i++) {  
                    hash.put(new Integer(i),Integer.valueOf(i));  
                }  
                System.out.println("t2 over");  
            }  
        };  
        t1.start();  
        t2.start();  
    }
	
	public static void main(String[] args) {
		new HashMapInfiniteLoop();
	}

}
