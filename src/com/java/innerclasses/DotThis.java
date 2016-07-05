package com.java.innerclasses;

/**
 * 如果你要生成对外部类对象的引用,可以使用外部类的名字,后面紧跟.this 这样产生的引用自动地具有正确的类型.
 * 这一点在编译期就被知晓并接受检查,因此没有任何运行时的开销.
 * @author gongchunru
 * @Package com.java.innerclasses
 * @date 16/6/23 13:15
 */
public class DotThis {
    void f(){
        System.out.println("DotThis.f()");
    }
    public class Inner{
        public DotThis outer(){
            return DotThis.this;
        }
    }
    public Inner inner(){
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.Inner dti = dt.inner();
        dti.outer().f();
    }
}
