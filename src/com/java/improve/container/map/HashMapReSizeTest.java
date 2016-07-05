package com.java.improve.container.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gongchunru
 * @Package com.java.improve.container.map
 * @date 16/6/2 23:23
 */
public class HashMapReSizeTest {
    public static void main(String[] args) {
        Map<String,Object> map  = new HashMap<String, Object>();
        Long begin = System.currentTimeMillis();
        for (int i=0;i<10000000;i++){
            map.put("i"+"i"+i,"i"+i);
        }
        Long end = System.currentTimeMillis();
        System.out.println("不指定容量,put 1000 0000 次所需时间"+(end-begin));
        System.out.println(map.size());

        Map<String,Object> map2  = new HashMap<String, Object>(10000000);
        Long begin2 = System.currentTimeMillis();
        for (int i=0;i<10000000;i++){
            map2.put("i"+"i"+i,"i"+i);
        }
        Long end2 = System.currentTimeMillis();
        System.out.println("指定容量,put 1000 0000 次所需时间"+(end2-begin2));
        System.out.println(map2.size());
    }
}
