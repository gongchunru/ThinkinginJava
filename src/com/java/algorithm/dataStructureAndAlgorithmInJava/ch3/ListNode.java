package com.java.algorithm.dataStructureAndAlgorithmInJava.ch3;

import java.util.List;

/**
 * 单向链表
 * Created by gongchunru on 2016/11/14.
 */
public class ListNode {
    private int data;
    private ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    /*
    时间复杂度为O(n) ，空间复杂度为O(1)
     */
    int listLength(ListNode headNode){
        int length = 0;
        ListNode currentNode = headNode;
        while (currentNode!=null){
            length++;
            currentNode = currentNode.getNext();
        }
        return length;
    }


    /**
     * 在链表中插入元素，
     *  1. 在开头插入元素
     *  2. 在结尾插入元素
     *  3. 在中间插入元素
     * @param headNode
     * @param nodeToInsert
     * @param position
     * @return
     */
    ListNode insertInLinkedList(ListNode headNode,ListNode nodeToInsert,int position){
        if (headNode == null){
            return nodeToInsert;
        }
        int size = listLength(headNode);

        if (position > size+1 || position<1){//链表的输入范围是从1-（size+1）
            System.out.println("Position of node to insert is invalid.The invalid inputs are 1 to "+(size+1));
            return headNode;
        }

        if (position==1){//在链表开头插入
            nodeToInsert.setNext(headNode);
            return nodeToInsert;
        }else {//在链表中间或者末尾插入元素
            ListNode previousNode = headNode;
            int count = 1;
            while (count<position-1){//遍历找到要插入元素的位置
                previousNode = previousNode.getNext();
                count++;
            }

            ListNode currentNode = previousNode.getNext();
            nodeToInsert.setNext(currentNode);
            previousNode.setNext(nodeToInsert);
        }
        return headNode;
    }

    /**
     * 单向链表的删除
     * 1. 删除链表的第一个节点
     * 2. 删除链表的中间一个节点
     * 3. 删除链表最后一个节点
     *
     * 时间复杂度为O(n)
     * @param headNode
     * @param position
     * @return
     */
    ListNode deleteNodeFromLinkedList(ListNode headNode,int position){
        int size = listLength(headNode);
        if (position > size || position<1){//链表的输入范围是从1-（size）
            System.out.println("Position of node to delete is invalid.The invalid inputs are 1 to "+(size));
            return headNode;
        }
        if (position==1){//删除表头节点
            ListNode currentNode = headNode.getNext();
            headNode = null;
            return currentNode;
        }else { //删除中间或者尾节点
            ListNode previous = headNode;
            int count = 1;
            while (count<position){
                previous = headNode.getNext();
                count++;
            }
            ListNode currentNode = previous.getNext();
            previous.setNext(currentNode.getNext());
            currentNode = null;
        }
        return headNode;
    }



}
