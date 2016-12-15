package com.java.algorithm.dataStructureAndAlgorithmInJava.ch6;

import com.java.algorithm.dataStructureAndAlgorithmInJava.ch3.DLLNode;

/**
 *
 * 实现队列的另一种方法,使用链表
 * 通过在链表中插入元素的方法实现队列
 * @author gongchunru
 * @Package com.java.algorithm.dataStructureAndAlgorithmInJava.ch6
 * @date 2016/12/5 23:44
 */
public class LLQueue {
    private DLLNode frontNode;
    private DLLNode rearNode;

    private LLQueue(){
        this.frontNode = null;
        this.rearNode = null;
    }

    public static LLQueue createQueue(){
        return new LLQueue();
    }

    public boolean isEmpty(){
        return (frontNode == null);
    }


    public  void enQueue(int data){
        DLLNode newNode = new DLLNode(data);

        if (rearNode !=null){
            rearNode.setNext(newNode);
        }

        rearNode = newNode;
        if (frontNode==null){
            frontNode = rearNode;
        }
    }

    public int deQueue() throws Exception {
        int data = 0;
        if (isEmpty()){
            throw  new Exception("Queue Empty");
        }else {
            data = frontNode.getData();
            frontNode = frontNode.getNext();
        }
        return data;
    }



}
