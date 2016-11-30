package com.java.algorithm.coursera;

/**
 * @author gongchunru
 * @Package com.java.algorithm.coursera
 * @date 2016/11/30 00:20
 */
public class QuickUnion {

    private int[] id;

    //初始化,每个元素的根元素指向自己
    public QuickUnion(int N){
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    //找到其根元素
    private int root(int i){
        while (i!=id[i]) i = id[i];
        return i;
    }

    public boolean connnected(int p,int q){
        return root(p) == root(q);
    }

    //连接 p和q 把p指向q ;p的根元素,指向q
    public void union(int p,int q){
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }


}
