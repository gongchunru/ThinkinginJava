package com.java.improve.IOTest.IO;

import java.io.*;

/**
 * Created by gongchunru on 2016/11/1.
 */
public class FileReaderFileWriter {

    public static void main(String[] args) {

    }

    public static void FileRFileW(String src,String out){
        FileWriter fileWriter = null;
        FileReader fileReader = null;


        try {
            // 如果文件不存在，会自动创建，如果存在，则会被覆盖
            fileWriter = new FileWriter(out);
            //1. 创建读取字符的流对象

            // 创建读取流对象时，必须明确被读取到的文件。
            fileReader = new FileReader(src);

            //创建一个临时容器，用于缓存读取到的字符
            char[] chars = new char[1024];

            //定义变量记录读取到的字符数，（其实就是往数组里面装字符的个数）

            int num = 0;
            while ((num = fileReader.read(chars))!=-1){
                fileWriter.write(chars,0,num);
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 字符流缓冲区读写文件 （高效） 仅限文本文件
     * @param src
     * @param out
     */
    public static void BufferRBufferW(String src,String out){
        BufferedWriter bufferedWriter = null;
        BufferedReader bufferedReader = null;


        try {
            bufferedWriter = new BufferedWriter(new FileWriter(out));
            bufferedReader = new BufferedReader(new FileReader(src));


            String line = "";
            while ((line = bufferedReader.readLine())!=null){
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 字节流读写复制文件
     * @param src
     * @param out
     */
    public static void InputStreamOutputStream(String src ,String out){
        FileOutputStream outputStream = null;
        FileInputStream inputStream = null;

        try {
            outputStream = new FileOutputStream(out);
            inputStream = new FileInputStream(src);
            byte[] bytes = new byte[1024];

            int num = 0;
            while ((num = inputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,num);
                outputStream.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void BufferInputBufferOutput(String src,String out){
        BufferedOutputStream bufferedOutputStream = null;
        BufferedInputStream bufferedInputStream = null;

        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(out));
            bufferedInputStream = new BufferedInputStream(new FileInputStream(src));

            byte[] bytes = new byte[1024];
            int num = 0;

            while ((num = bufferedInputStream.read(bytes))!=-1){
                bufferedOutputStream.write(bytes,0,num);
                bufferedOutputStream.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                bufferedOutputStream.close();
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
