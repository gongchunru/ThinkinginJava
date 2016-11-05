package com.java.test;

/**
 * Created by gongchunru on 2016/8/11.
 */
public class TestConst {

    public static void main(String[] args) {
        int[] data = new int[]{5, 3, 6, 2, 1, 9, 4, 8, 7};
        print(data);
        selectSort(data);
        print(data);

    }
    public static void swap(int[] data,int i,int j){
        data[i] = data[i]+data[j];
        data[j] = data[i]-data[j];
        data[i] = data[i]-data[j];
    }

    public static void selectSort(int[] data){
        for (int i = 0; i < data.length; i++) {
            int min = i;
            for (int j = i+1; j < data.length; j++) {
                if (data[j]<data[min]){
                    min = j;
                }
            }

            if(min!=i){
                swap(data,i,min);
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
