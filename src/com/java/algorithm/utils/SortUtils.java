package com.java.algorithm.utils;

import java.util.*;

/**
 * 算法中用到的一些工具类
 * Created by gongchunru on 2016/10/26.
 */
public class SortUtils {

    //生成有n个元素的随机数组，每个元素的随机范围为[rangeL,rangeR]
    public static int[] generateRandomArray(int n){
        Object[] arr = new Object[n];
        int[] arr2 = new int[n];
        Random random = new Random();
        Set<Integer> intSet = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            intSet.add(random.nextInt(n)+(1<<16));
        }
        arr = intSet.toArray();
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = (int)arr[i] - (1<<16);
        }
        System.out.println("随机生成数组大小为："+arr2.length+"\n"+"生成数组为："+ Arrays.toString(arr2));
        return arr2;
    }


    public static void swap(int[] data,int x,int y){
        int temp = data[x];
        data[x] = data[y];
        data[y] = temp;
    }

    //判断是不是排序的数组
    public static boolean isSorted(int[] arr,int n){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }
}
