package com.xiong.Nio;

import java.io.*;
import java.net.Socket;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/19 20:16
 * @description：  发送数据到端口
 * @modified By：
 * @version: $
 */
public class SendDataToPort {

    public static void main(String[] args) {
       new SendDataToPort().send(8081);
    }

    private void send(int port) {

        try {
            Socket socket = new Socket("localhost",port);

            OutputStream oos = socket.getOutputStream();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(oos));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line= null;
            while((line=br.readLine())!=null){
                bw.write(line);
                bw.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
