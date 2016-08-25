package com.java.algorithm.baseSort;

/**
 * @author gongchunru
 * @Package com.java.algorithm.baseSort
 * @date 16/8/21 23:26
 *
 * 待排序的元素按关键字的大小，插入到前面已经排序的有序序列中。
 * 效率低
 *
 * 直接插入的效率并不高，如果在最坏的情况下，比较次数(0+1+...+n-1) = O(n^2).
 * 其他情况下，也要考虑元素的次数，时间复杂度为O(n^2)
 * 空间效率很好，空间复杂度为O(1)
 * 稳定的
 *
 * 算法描述：
 * 对一个有n个元素的数据序列，排序需要进行n-1 趟插入操作。
 * 第1趟插入，将第2个元素插入到前面的有序子列中，
 * 第2趟插入，将第3个元素插入到前面的有序子列中。
 * 第n-1趟插入，将第n个元素插入到前面的有序子列中。

 *
 */
public class InsertSortTest {
//    public  static int count = 0;

    public static void main(String[] args) {
        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        print(data);
        insertSort(data);
        print(data);
    }
    public static void insertSort(int[] data){
        for (int i = 1; i < data.length; i++) {
            //缓存第i个元素
            int tmp = data[i];
            int j = i-1;
            if (data[j]>data[i]){
                //整体向后移动一格
                while (j>=0 && data[j]>tmp){
                    data[j+1] = data[j];
                    j--;
                }
                //最后将tmp插入合适的位置
                data[j+1] = tmp;
                print(data);
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
