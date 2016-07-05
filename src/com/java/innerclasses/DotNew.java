package com.java.innerclasses;

/**告知其他对象,去创建其某个内部类对象. 要实现此目的,你必须在new表达式中提供对其他外部类对象的引用.
 * @author gongchunru
 * @Package com.java.innerclasses
 * @date 16/6/23 14:10
 */
public class DotNew {
    public class Inner{}

    public static void main(String[] args) {
        DotNew dn  = new DotNew();
        DotNew.Inner dni = dn.new Inner();
    }
}
