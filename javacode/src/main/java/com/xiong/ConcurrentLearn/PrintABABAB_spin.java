package com.xiong.ConcurrentLearn;

import java.util.concurrent.TimeUnit;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/31 15:00
 * @description：  直接 自旋锁 或者 synchronized 锁住打印的那句话，我想复杂了
 * @modified By：
 * @version: $
 */
public class PrintABABAB_spin {

    static class Resource {

        Resource(int n) {
            this.n = n;
        }

        private volatile int flag = 0;

        private volatile int n;

        public void printA() {

            for (int i = 0; i < n; i++) {
                while (flag != 0){}

               //synchronized (this){
                   //干活
                   System.out.print("A");

                    flag = 1;
              // }

            }

        }

        public void printB() {

            for (int i = 0; i < n; i++) {

                while (flag != 1){}
                //synchronized (this) {
                    System.out.print("B");

                    flag = 0;
                //}

            }

        }

    }


    public static void main(String[] args) {

        // 传入 打印的 AB 节 的个数
        PrintABABAB.Resource rs = new PrintABABAB.Resource(9);

        new Thread(new Runnable() {
            @Override
            public void run() {
                rs.printA();
            }
        }, "AA").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                rs.printB();
            }
        }, "BB").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}
