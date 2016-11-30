package com.java.algorithm.dataStructureAndAlgorithmInJava.ch4;

/**
 * @author gongchunru
 * @Package com.java.algorithm.dataStructureAndAlgorithmInJava.ch4
 * @date 2016/11/17 21:15
 */
public class ArrayStack {
    private int top;
    private int capacity;
    private int[] array;

    public ArrayStack(int[] array, int capacity, int top) {
        this.array = new int[capacity];
        this.capacity = 1;
        this.top = -1;
    }


    public boolean isEmpty(){
        return (top == -1);
    }


    public boolean isStackFull(){
        return (top == capacity-1);
    }

    public void push(int data){
        if (isStackFull()){
            System.out.println("Stack Overflow");
        }

        array[++top] = data;
    }

    public int pop(){
        if (isStackFull()){
            System.out.println("Stack is Empty");
            return  0;
        }else {
            return (array[top--]);
        }
    }

    public void deleteStack(){
        top = -1;
    }

}
