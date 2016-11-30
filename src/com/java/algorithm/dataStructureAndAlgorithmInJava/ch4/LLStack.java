package com.java.algorithm.dataStructureAndAlgorithmInJava.ch4;

import com.java.algorithm.dataStructureAndAlgorithmInJava.ch3.ListNode;

import java.util.EmptyStackException;

/**
 * @author gongchunru
 * @Package com.java.algorithm.dataStructureAndAlgorithmInJava.ch4
 * @date 2016/11/17 22:44
 *
 * 链表实现栈
 */
public class LLStack {
    private ListNode headNode;

    public LLStack(){
        this.headNode = new ListNode(0);
    }

    public void push(int data){
        if (headNode == null){
            headNode = new ListNode(data);
        }else if (headNode.getData()==0){
            headNode.setData(data);
        }else {
            ListNode node = new ListNode(data);
            node.setNext(headNode);
            headNode = node;
        }
    }

    public int top(){
        if (headNode == null){
            return 0;
        }else{
            return headNode.getData();
        }
    }

    public int pop(){
        if (headNode == null){
            System.out.println("Stack empty");
            return 0;
        }else {
            int data = headNode.getData();
            headNode = headNode.getNext();
            return data;
        }
    }

    public boolean isEmpty(){
        if (headNode == null){
            return true;
        }else{
            return false;
        }
    }

    public void deleteStack(){
        while (headNode!=null){
//            headNode.setData(null);
//            headNode = headNode.getNext();
            headNode = null;
        }
    }

}
