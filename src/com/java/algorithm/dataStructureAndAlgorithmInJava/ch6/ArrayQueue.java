package com.java.algorithm.dataStructureAndAlgorithmInJava.ch6;

/**
 * @author gongchunru
 * @Package com.java.algorithm.dataStructureAndAlgorithmInJava.ch6
 * @date 2016/12/5 21:12
 */
public class ArrayQueue {
    private int front;
    private int rear;
    private int capacity;
    private int[] array;

    public ArrayQueue(int size) {
        array = new int[size];
        this.capacity = size;
        this.front = -1;
        this.rear = -1;
    }


    private static ArrayQueue createQueue(int size){
        return new ArrayQueue(size);
    }

    public boolean isEmpty (){
        return (front == -1);
    }

    public boolean isFull(){
        return ((rear+1)%capacity == front);
    }

    public int getQueueSize(){
        return ((capacity-front+rear+1)%capacity);
    }

    public void enQueue(int data) throws Exception {
        if (isFull()){
            throw new Exception("Queue OverFlow");
        }else {
            rear = (rear+1)%capacity;
            array[rear] = data;
            if (front==-1){
                front = rear;
            }

        }
    }

    public int deQueue() throws Exception {
        int data = 0;
        if (isEmpty()){
            throw  new Exception("Empty");
        }else{
            data = array[front];
            if (front == rear){
                front = rear -1;
            }else {
                front = (front+1)%capacity;
            }
            return data;
        }
    }
}
