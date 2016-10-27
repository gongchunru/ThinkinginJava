package com.java.improve.Patterns.composite;

/**
 * Created by gongchunru on 2016/10/27.
 */
public class CompositePatternDemo {
    public static void main(String[] args) {
        Employee CEO = new Employee("John","CEO",30000);
        Employee headSales = new Employee("Robert","Head Sales",20000);
        Employee headMarketing = new Employee("Michel","Head Marketing",20000);
        Employee clerk1 = new Employee("Laura","Marketing",10000);
        Employee clerk2 = new Employee("Bob","Marketing",10000);

        Employee salesExecutive1 = new Employee("Richard","Sales",10000);
        Employee saleSExeCutive2 = new Employee("Bob","Sales",10000);

        CEO.add(headSales);
        CEO.add(headMarketing);

        headSales.add(salesExecutive1);
        headSales.add(saleSExeCutive2);

        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        System.out.println(CEO);
        for (Employee employee : CEO.getSubordinates()) {
            System.out.println(employee);
            for (Employee employee1 : employee.getSubordinates()) {
                System.out.println(employee1);
            }
        }
    }
}
