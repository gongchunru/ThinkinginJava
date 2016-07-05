package com.java.innerclasses.innerclassesTest;

/**
 * 参考文章:http://www.cnblogs.com/aigongsi/archive/2012/04/24/2467183.html
 * @author gongchunru
 * @Package com.java.innerclasses.innerclassesTest
 * @date 16/6/28 14:42
 */
public class NestedClassLevel {
    class A {
        //       编译器会报错,A里面不能定义名为A的nested classes
//       class A{}
        public void test() {
            class B {
            }
        }
    }

    class B{
        public void test(){
            //可以无限定义匿名类
            new Runnable(){
              public void run(){
                  //可以无限定义匿名类
                  new Runnable(){
                      public void run() {

                      }
                  };
              }
            };
        }
    }
//    只能定义一个B
//    class B{}

    public void test(){
        //可以定义A
        class A{
            public void test(){
                //可以有同名的局部类B和成员类B
                class B{
                    public void test(){

                    }
                }
                //局部类A中不能定义A
//                class A{}
            }
        }

        //可以有同名的局部类B和成员类B
        class B{

        }
    }
}
