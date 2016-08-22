package com.java.algorithm.baseSort;

/**
 * @author gongchunru
 * @Package com.java.algorithm.baseSort
 * @date 16/8/21 21:46
 * 冒泡排序,时间复杂度O(n^2),    堆排序,快速排序O(nlogn,底数是2)
 * 优点: 1. 编程复杂度低,容易写
 *      2. 具有稳定性, 堆和快排 不具有稳定性
 *
 * 一路,二路归并排序,不平衡二叉树排序的速度比冒泡排序快,具有稳定性,但速度不及堆排序,快速排序.
 * 冒泡排序经过 n-1 趟子排序完成. 第i趟子排序从第1个数到第n-i个数,若第i个数比后一个数大
 *
 * 冒泡排序算法稳定，O(1)的额外的空间，比较和交换的时间复杂度都是O(n^2)，自适应，对于已基本排序的算法，时间复杂度为O(n)。
 * 冒泡算法的许多性质和插入算法相似，但对于系统开销高一点点。
 *
 */
public class BubbleSortTest {
    public static void main(String[] args) {
        int[] data = new int[]{5, 3, 6, 2, 1, 9, 4, 8, 7};
        print(data);
        bubbleSort(data);
        System.out.println("排序后的数组");
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



    public static void bubbleSort(int[] data){
        for (int i = 0; i < data.length; i++) {
            //记录某趟是否发生交换
            boolean isSorted = false;
            for (int j = 0; j <data.length-i-1; j++) {
                if (data[j] > data[j+1]){// 从小到大排序
                    swap(data,j,j+1);
                    isSorted = true;
                    print(data);
                }
            }
            System.out.println(i+"次排序:" );
            print(data);
            if (!isSorted){
                break;
            }
        }
    }


    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }
}
