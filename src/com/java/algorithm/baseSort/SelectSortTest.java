package com.java.algorithm.baseSort;

/**
 * Created by gongchunru on 2016/8/18.
 */
public class SelectSortTest {
    public static void main(String[] args) {
        int[] data = new int[]{5, 3, 6, 2, 1, 9, 4, 8, 7};
        print(data);
        selectSort(data);
        System.out.println("排序后的数列：");
        print(data);
    }

    public static void swap(int[] data,int i,int j){
        data[i] = data[i]+data[j];
        data[j] = data[i]-data[j];
        data[i] = data[i]-data[j];
    }

    public static void selectSort(int[] data){
        for (int i = 0; i < data.length; i++) {
            int minIndex = i;
            for (int j = i+1; j <data.length ; j++) {
                if (data[j]<data[minIndex]){
                    minIndex=j;
                    System.out.println("第"+j+"趟比较，当前的最小值："+data[minIndex]);
                }
            }
            if (minIndex!=i){//如果不想等，说明data[minIndex]比data[i]最小，则和data[i]交换
                swap(data,i,minIndex);
                print(data);
            }
        }

    }

    public static void print(int[] data){
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+"\t");
        }
        System.out.println();
    }
}
