package com.java.algorithm.baseSort;

/**
 * Created by gongchunru on 2016/8/17.
 */
public class MergeSortTest {

    public static void main(String[] args) {
        int[] data = new int[]{5,3,6,2,1,9,4,8,7};
        print(data);
        mergeSort(data);
        System.out.println("排序后的数组：");
        print(data);
    }

    public static void mergeSort(int[] data){
        sort(data,0,data.length-1);
    }



    public static void sort(int[] data,int left,int right){
        if (left >= right)
            return;
        int center = (left+right)/2;

        sort(data,left,center);

        sort(data,center+1,right);
        // 合并
        merge(data,left,center,right);
        print(data);
    }

    /**
     *
     * @param data 数组对象，
     * @param left 左数组第一个元素，
     * @param center 左数组最后一个元素的索引，center+1是右数组第一个元素的索引
     * @param right  右数组最后一个元素的索引
     */
    public static void merge(int[] data,int left,int center,int right){
        //临时数组
        int[] tempArr = new int[data.length];

        //右数组第一个元素的索引
        int mid = center+1;

        //记录临时数组的索引
        int third = left;
        //缓存左数组第一个元素的索引
        int temp = left;

        while (left<=center &&  mid <=right){
            //从两个数组中取出最小的放入临时数组
            if (data[left] <= data[mid]){
                tempArr[third++] = data[left++];
            }else{
                tempArr[third++] = data[mid++];
            }
        }

        //剩余部分一次放入临时数组（实际上连个while置灰执行其中一个）
        while (mid<=right){
            tempArr[third++] = data[mid++];
        }
        while (left<=center){
            tempArr[third++] = data[left++];
        }

        //将临时数组中的内容拷贝回原数组中
        //(原left+center范围内的内容将被复制到原数组中去)
        while (temp<=right){
            data[temp] = tempArr[temp++];
        }
    }

    public static void print(int[] data){
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]+"\t");
        }
        System.out.println();
    }
}


