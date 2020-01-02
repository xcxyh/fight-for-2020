package com.xiong.Nio;// $Id$

import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class CopyFile {
    static public void main(String args[]) throws Exception {
        if (args.length < 2) {
            System.err.println("Usage: java CopyFile infile outfile");
            System.exit(1);
        }

        String infile = args[0];
        String outfile = args[1];

        FileInputStream fin = new FileInputStream(infile);
        FileOutputStream fout = new FileOutputStream(outfile);
        //从 FileInputStream 获取 Channel
        FileChannel fcin = fin.getChannel();
        FileChannel fcout = fout.getChannel();
        // 创建 Buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //不断读写 读写 。。。
        //clear() 方法重设缓冲区，使它可以接受读入的数据。 flip() 方法让缓冲区可以将新读入的数据写入另一个通道。
        while (true) {
            buffer.clear();
            //将数据从 fcin 读到 Buffer 中
            int r = fcin.read(buffer);
            //EOF
            if (r == -1) {
                break;
            }

            buffer.flip();
            //将数据写到输出通道 fcout
            fcout.write(buffer);
        }


    }
}
