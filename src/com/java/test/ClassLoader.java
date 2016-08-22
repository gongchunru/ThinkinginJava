package com.java.test;

import java.net.URL;

/**
 * @author gongchunru
 * @Package com.java.test
 * @date 16/8/21 08:01
 */
public class ClassLoader {
    public static void main(String[] args) {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }
        //也可以通过以下内容获取:
        System.out.println(System.getProperty("sun.boot.class.path"));





    }

}
