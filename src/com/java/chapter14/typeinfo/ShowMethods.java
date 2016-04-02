package com.java.chapter14.typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;
import static com.java.chapter14.net.mindview.util.Print.*;

/**
 * @author gongchunru
 * @Package com.java.chapter14.typeinfo
 * Using reflection to show all the methods of a class
 * even if the methods are defined in the base class
 *
 */
public class ShowMethods  {
    private static String usage =
            "usage:\n" +
                    "ShowMethods qualified.class.name\n " +
                    "To show all methods in class or:\n " +
                    "ShowMethods qualified.class.name\n " +
                    "To search for methods involving 'word'";
    private static Pattern p = Pattern.compile(" \\w+\\.");

    public static void main(String[] args) {
        if (args.length < 1){
            print(usage);
            //0:正常退出,程序正常秩序结束退出;1:非正常退出,就是说无论程序正在执行与否,都退出.
            System.exit(0);
        }
        int lines = 0;
        try {
            Class<?> c = Class.forName(args[0]);
            Method[] methods = c.getMethods();
            Constructor[] ctors = c.getConstructors();
            if (args.length == 1){
                for (Method method:methods){
                    print(p.matcher(method.toString()).replaceAll(""));
                    for (Constructor ctor:ctors){
                        print(p.matcher(ctor.toString()).replaceAll(""));
                    }
                    lines = methods.length + ctors.length;
                }
            }else {
                for (Method method:methods){
                    if (method.toString().indexOf(args[1]) != -1){
                        print(p.matcher(method.toString()).replaceAll(""));
                        lines++;
                    }
                    for (Constructor ctor:ctors){
                        print(p.matcher(ctor.toString()).replaceAll(""));
                        lines++;
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            print("No such class:"+e);
        }
    }
}
