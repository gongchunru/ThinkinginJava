package com.java.exceptions;

/**
 * @author gongchunru
 * @Package com.java.exceptions
 * @date 16/6/29 17:16
 */
class SimpleException extends Exception{}
public class InheritingExceptions  {
    public void f() throws SimpleException{
        System.out.println("throws SimpleException from f()");
        throw  new SimpleException();
    }

    public static void main(String[] args) {
        InheritingExceptions sed = new InheritingExceptions();
        try {
            sed.f();
        }catch (SimpleException e){
            System.out.println("Caught it!");
        }
    }
}
