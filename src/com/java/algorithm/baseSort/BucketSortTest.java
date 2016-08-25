package com.java.algorithm.baseSort;

/**
 * Created by gongchunru on 2016/8/23.
 * 待排序序列满足如下特征
 * 1. 待排序列所有的值处于一个可枚举的范围之类；
 * 2. 待排序列所在的这个可枚举的范围不应该太大，否则排序开销太大。
 *
 * （1）对于这个可枚举范围构建一个buckets数组，用于记录“落入”每个桶中元素的个数；
    （2）将（1）中得到的buckets数组重新进行计算，按如下公式重新计算：
 *
 */
public class BucketSortTest {
    public static int count = 0;

    public static void main(String[] args) {
        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        print(data);
        bucketSort(data, 0, 10);
        print(data);
    }

    public static void bucketSort(int[] data,int min, int max){
        //缓存数组
        int[] tmp = new int[data.length];
        //buckets 用于记录待排序元素的信息
        //buckets 数组定义了max-min个桶
        int[] buckets = new int[max-min];
        //计算每个元素在序列中出现的次数
        for (int i = 0; i < data.length; i++) {
            buckets[data[i]-min]++;
        }
        //计算“落入”各个桶内的元素在有序序列中的位置.
        for (int i = 1; i < max-min; i++) {
            buckets[i] = buckets[i] + buckets[i-1];
        }
        //将data中的元素完全赋值到tmp数组中
        System.arraycopy(data,0,tmp,0,data.length);

        //根据buckets数组中的信息将待排序列的各元素放入相应位置。
        for (int k = data.length-1; k >=0 ; k--) {
            data[--buckets[tmp[k]-min]] = tmp[k];
        }
    }

    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }
}
