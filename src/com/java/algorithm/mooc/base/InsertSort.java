package com.java.algorithm.mooc.base;

import com.java.algorithm.utils.SortUtils;

import java.util.Arrays;

/**
 * Created by gongchunru on 2016/10/27.
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = SortUtils.generateRandomArray(300);
        int[] arr2 = Arrays.copyOf(arr,arr.length);
        long startTime = System.nanoTime();

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j >0 ; j--) {
                if (arr[j-1]>arr[i]){
//                    SortUtils.swap(arr,j,i);
                    swap(arr,i,j-1);
                }else {
                    break;
                }
            }
        }
        long endTime = System.nanoTime();

        System.out.println(Arrays.toString(arr));
        System.out.println("时间："+(endTime-startTime));


        System.out.println(Arrays.toString(arr2));

        startTime = System.nanoTime();
        sort2(arr2);
        endTime = System.nanoTime();
        System.out.println(Arrays.toString(arr2));
        System.out.println("时间："+(endTime-startTime));
    }

    public static void swap(int[] data,int x,int y){
        int temp = data[x];
        data[x] = data[y];
        data[y] = temp;
    }

    private static void sort2(int[] arr){
        int n = arr.length;
        int temp = arr[1];
        for (int i = 1; i < n; i++) {
            temp = arr[i];
            int j;
            for (j = i; j >0&&arr[j-1]>temp; j--) {
                    arr[j] = arr[j-1];

            }
            arr[j] = temp;
        }

    }
}
