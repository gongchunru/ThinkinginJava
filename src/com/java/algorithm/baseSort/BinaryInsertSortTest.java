package com.java.algorithm.baseSort;

/**
 * Created by gongchunru on 2016/8/22.
 * 折半插入排序法，又称二分插入排序法，是直接插入排序法的改良版，也需要执行i-1趟插入，
 * 不同之处在于，第i趟插入，先找出第i+1个元素应该插入的的位置，假定前i个数据是已经处于有序状态。
 */
public class BinaryInsertSortTest {

    public static int count = 0;

    public static void main(String[] args) {
        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        print(data);
        binaryInsertSort(data);
        print(data);
    }

    public static void binaryInsertSort(int[] data){
        for (int i = 1; i <data.length; i++) {
            if (data[i-1]>data[i]){
                //缓存i处的元素
                int tmp = data[i];
                //记录搜索范围的左边界
                int low = 0;
                //记录搜索范围的右边界
                int high = i-1;
                while (low<=high){
                    //记录中间位置
                    int mid = (low + high)/2;
                    //比较中间位置和i处数据大小，以缩小搜索范围
                    if (data[mid] < tmp){
                        low = mid + 1;
                    }else {
                        high = mid - 1;
                    }
                }
                //将low - i 处数据整体后移动1位
                for (int j = i; j >low; j--) {
                    data[j] = data[j-1];
                }
                data[low] = tmp;
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
