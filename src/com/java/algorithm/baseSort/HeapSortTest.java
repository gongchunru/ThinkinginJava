package com.java.algorithm.baseSort;

/**
 * Created by gongchunru on 2016/8/19.
 *
 *
 */
public class HeapSortTest {
    public static void main(String[] args) {
        int[] data = new int[]{5,3,6,2,1,9,4,8,7};
        print(data);
        heapSort(data);
        System.out.println("排序后的数组：");
        print(data);
    }


    public static void swap(int[] data,int i,int j){
        if (i == j)
            return;
        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];

    }

    public static void heapSort(int[] data){
        for (int i = 0; i < data.length; i++) {
            createMaxdHeap(data,data.length-1-i);
            swap(data,0,data.length-1-i);
            print(data);
        }
    }
    public static void createMaxdHeap(int[] data,int lastIndex){
        for (int i = (lastIndex - 1)/2;i>=0;i--){
            //保存当前判断的节点
            int k = i;
            //如果当前子节点存在
            while (2*k+1 <=lastIndex){
                //biggerIndex总是记录较大节点的值，先赋值为当前判断节点的左子节点
                int biggerIndex = 2 * k + 1;
                if (biggerIndex<lastIndex){
                    //若右子节点存在，则此事biggerIndex应该等于lastIndex
                    if (data[biggerIndex]<data[biggerIndex+1]){
                        //若右子节点值比左子节点值大，则biggerIndex记录的是右子节点的值。
                        biggerIndex++;
                    }
                }
                if (data[k]<data[biggerIndex]){
                    //若当前节点值比子节点最大值小，则交换2者得值，交换后将biggerIndex值赋值给k
                    swap(data,k,biggerIndex);
                    k = biggerIndex;
                    System.out.print("当前节点是："+data[k]+": \t");
                    print(data);
                }else{
                    break;
                }
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
