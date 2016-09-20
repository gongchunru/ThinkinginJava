package com.java.improve.NIODemo.TestCase;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by gongchunru on 2016/9/20.
 */
public class FastCopyFile {
    public static void main(String[] args) throws Exception {
        if (args.length<2){
            System.err.println("Usage:java FastCopyFile infile outfile");
            System.exit(1);
        }

        String infile = args[0];
        String outfile = args[0];

        FileInputStream fin = new FileInputStream(infile);
        FileOutputStream fout = new FileOutputStream(outfile);

        FileChannel fcin = fin.getChannel();
        FileChannel fcout = fout.getChannel();

        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        while (true){
            buffer.clear();
            int r = fcin.read(buffer);

            if (r==-1){
                break;
            }

            buffer.flip();

            fcout.write(buffer);
        }

    }
}
