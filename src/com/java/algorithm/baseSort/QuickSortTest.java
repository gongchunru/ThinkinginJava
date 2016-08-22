package com.java.algorithm.baseSort;

/**
 * @author gongchunru
 * @Package com.java.algorithm.baseSort
 * @date 16/8/21 22:28
 *
 *
 */
public class QuickSortTest {
    public static void main(String[] args) {

        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        print(data);
        quickSort(data, 0, data.length - 1);
        System.out.println("排序后的数组：");
        print(data);
    }


    public static void swap(int[] data, int i, int j) {
        if (i == j) {
            return;
        }
        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }

    public static void quickSort(int[] data,int start,int end){
        if (start >= end)
            return;

        //以起始索引为分界点
        int pivot = data[start];
        int i = start+1;
        int j = end;
        while (true){
            while (i<=end && data[i]<pivot){
                i++;
            }
            while (j>start && data[j]>pivot){
                j--;
            }
            if (i<j){
                swap(data,i,j);
            }else {
                break;
            }
        }
        //交换j和分界点的值
        swap(data,start,j);
        print(data);

        //递归左子序列
        quickSort(data,start,j-1);
        //递归右子序列
        quickSort(data,j+1,end);
    }


    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }
}














