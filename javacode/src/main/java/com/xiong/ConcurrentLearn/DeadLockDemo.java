package com.xiong.ConcurrentLearn;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/24 20:25
 * @description： 死锁示例
 *  排查和修复手段：
 *  首先，终端中（Terminal）使用命令 jps -l (-l 是显示全名) 查看java 的运行程序 找到目标程序的 进程号（17360）
 *
 *  然后，终端中（Terminal）使用命令 jstack 进程号（17360）
 *
 *  出现结果：
 * ===================================================
 * "ThreadBBBBB":
 *         at com.xiong.ConcurrentLearn.deadTesk.run(DeadLockDemo.java:33)
 *         - waiting to lock <0x00000000d61bb9b8> (a java.lang.String)
 *         - locked <0x00000000d61bb9f0> (a java.lang.String)
 *         at java.lang.Thread.run(Thread.java:745)
 * "ThreadAAAAA":
 *         at com.xiong.ConcurrentLearn.deadTesk.run(DeadLockDemo.java:33)
 *         - waiting to lock <0x00000000d61bb9f0> (a java.lang.String)
 *         - locked <0x00000000d61bb9b8> (a java.lang.String)
 *         at java.lang.Thread.run(Thread.java:745)
 *
 * Found 1 deadlock.
 *
 * @modified By：
 * @version: $
 */



public class DeadLockDemo {
     static class deadTesk implements Runnable {

        private final String lockA;
        private final String lockB;

        public deadTesk(String lockA, String lockB) {
            this.lockA = lockA;
            this.lockB = lockB;
        }


        @Override
        public void run() {
            synchronized (lockA) {//对象锁

                System.out.println(Thread.currentThread().getName() + "\t持有锁：" + lockA + "\t尝试获得锁：" + lockB);

                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockB) {

                    System.out.println(Thread.currentThread().getName() + "\t持有锁：" + lockB + "\t尝试获得锁：" + lockA);
                }
            }
        }
    }

    public static void main(String[] args) {

        String lockA="lockA";
        String lockB="lockB";
        new Thread(new deadTesk(lockA,lockB),"ThreadAAAAA").start();
        new Thread(new deadTesk(lockB,lockA),"ThreadBBBBB").start();
        //ConcurrentHashMap
    }


}
