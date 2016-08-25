package com.java.algorithm.baseSort;

/**
 * Created by gongchunru on 2016/8/23.
 * 希尔排序 属于插入类排序，由Shell提出，希尔排序对直接插入排序进行了简单的改进：它通过加大插入排序中元素之间的间隔，
 * 并在这些有间隔的元素中进行插入排序，从而使数据项大跨度地移动，当这些数据项排过一趟序之后，
 * 希尔排序算法减小数据项的间隔再进行排序，依次进行下去，进行这些排序时的数据项之间的间隔被称为增量，习惯上用字母h来表示这个增量。
 常用的h序列由Knuth提出，该序列从1开始，通过如下公式产生：
 h = 3 * h +1
 反过来程序需要反向计算h序列，应该使用
 h=(h-1)/3
 */
public class ShellSortTest {
    public static int count = 0;

    public static void main(String[] args) {
        int[] data = new int[]{ 5, 3, 6, 2, 1, 9, 4, 8, 7};
        print(data);
        shellSort(data);
        System.out.println("排序后的数组：");
        print(data);
    }

    public static void shellSort(int[] data){
        //计算出最大值
        int h = 1;
        while (h<=data.length/3){
            h = h * 3 + 1;
        }

        while (h>0){
            for (int i = h; i < data.length; i+=h) {
                if (data[i]<data[i-h]){
                    int tmp = data[i];
                    int j = i-h;
                    while (j>=0&&data[j]>tmp){
                        data[j+h] = data[j];
                        j-=h;
                    }
                    data[j+h] = tmp;
                    print(data);
                 }
            }
            //计算出下一个值
            h = (h-1)/3;
        }
    }
    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }
}
