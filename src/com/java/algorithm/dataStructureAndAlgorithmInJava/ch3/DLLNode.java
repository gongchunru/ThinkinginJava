package com.java.algorithm.dataStructureAndAlgorithmInJava.ch3;

/**
 * @author gongchunru
 * @Package com.java.algorithm.dataStructureAndAlgorithmInJava.ch3
 * @date 2016/11/15 00:51
 */
public class DLLNode {
    private int data;
    private DLLNode next;
    private DLLNode previous;
    public DLLNode(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DLLNode getNext() {
        return next;
    }

    public void setNext(DLLNode next) {
        this.next = next;
    }

    public DLLNode getPrevious() {
        return previous;
    }

    public void setPrevious(DLLNode previous) {
        this.previous = previous;
    }
}