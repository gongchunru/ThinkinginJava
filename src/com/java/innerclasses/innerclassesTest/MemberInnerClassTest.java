package com.java.innerclasses.innerclassesTest;

/**
 * @author gongchunru
 * @Package com.java.innerclasses.innerclassesTest
 * @date 16/6/28 13:16
 */
public class MemberInnerClassTest {
    public static void main(String[] args) {
        //可以在任何地方创建
        MemberInnerClass t = new MemberInnerClass();

        //可以创建,pmic里面保存对t的引用
        MemberInnerClass.PublicMemberInnerClass pmic = t.new PublicMemberInnerClass();


        //可以在同一package下创建,dmic保存对t的引用
        MemberInnerClass.DefaultMemberInnerClass dmic = t.new DefaultMemberInnerClass();

//    编译错误,无法访问内部类
//    MemberInnerClass.PrivateMemberInnerClass pmic = t.new PrivateMemberInnerClass();

        System.out.println(pmic.getOutterClass() == t);
        System.out.println(dmic.getOutterClass() == t);

    }

}
