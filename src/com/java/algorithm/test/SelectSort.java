package com.java.algorithm.test;

/**
 * Created by gongchunru on 2016/9/12.
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        prit(data);

    }

    public static void swap(int[] data,int i,int j){
        if (i==j) return;

        data[i] = data[i]+data[j];
        data[j] = data[i]-data[j];
        data[i] = data[i]-data[j];

    }

    public static void sort(int[] data){

    }


    public static void prit(int[] data){
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+"\t");
        }
        System.out.println();
    }

}
