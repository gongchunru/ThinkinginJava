package com.java.algorithm.dataStructureAndAlgorithmInJava.ch4;

/**
 * @author gongchunru
 * @Package com.java.algorithm.dataStructureAndAlgorithmInJava.ch4
 * @date 2016/11/17 22:24
 */
public class DynArrayStack {
    private int top;
    private int capacity;
    private int[] array;
    public DynArrayStack(){
        capacity = 1;
        array = new int[1];
        top = -1;
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isStackFull(){
        return (top == capacity - 1);
    }

    public void push(int data){
        if (isStackFull()){
            doubleStack();
        }
        array[++top] = data;
    }

    public void doubleStack(){
        int newArray[] = new int[capacity*2];
        System.arraycopy(array,0,newArray,0,capacity);
        capacity = capacity * 2;
        array = newArray;
    }

    public int pop(){
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return 0;
        } else {
            return array[top--];
        }
    }

    public void deleteStack(){
        top = -1;
    }
}
