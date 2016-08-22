package com.java.algorithm.baseSort;

/**
 * @author gongchunru
 * @Package com.java.algorithm.baseSort
 * @date 16/8/21 23:26
 */
public class InsertSortTest {
    public  static int count = 0;

    public static void main(String[] args) {
        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        print(data);
        insertSort(data);
        print(data);
    }

    public static void insertSort(int[] data){

    }

    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }

}
