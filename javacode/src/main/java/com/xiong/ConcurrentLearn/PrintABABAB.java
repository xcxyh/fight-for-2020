package com.xiong.ConcurrentLearn;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/31 14:12
 * @description： 两个线程交替打印 ABABAB,
 *
 *  默写时所犯错误：
 *
 * 1 ReentrantLock 拼不对，（这个太艹了）
 * 2 共用一把锁也没写对，一个锁上可以new 多个 condition
 * 3 等待 执行 通知 的顺序也记错了，
 * 4 lock.lock() 方法 在 try 块之外 也没写对,
 *       在 finally 块中 写 lock.unlock() 方法，保证出现异常之后仍能正常释放掉锁
 * 5 在 for 循环内部加锁 也写到外面去了
 * 6 使用 await() 阻塞 ，signal() 唤醒， 慌张之下也写成了 notify() 唤醒
 * 7 创建 condition 时调用 lock.newCondition() 方法 ，也写错了 写成了 lock.condition()
 * 8 传入 Runnable 匿名内部类 到 Thread时 ，写lambda 表达式也写错了
 *   还是改成了 new Thread(new Runnable(){
 *       @Override
 *             public void run() {
 *                 // 调用new 出来的 资源类的方法
 *             }
 *   }, "thread name").start();
 *
 * @modified By：
 * @version: $
 */
public class PrintABABAB {


    static class Resource {

        Resource(int n){
            this.n = n;
        }

        private volatile int flag = 0;
        private volatile int n;
        private Lock lock = new ReentrantLock();

        Condition ca = lock.newCondition();
        Condition cb = lock.newCondition();

        public void printA() {

            for (int i = 0; i < n; i++) {
                //加锁
                lock.lock();
                try {
                    //等待
                    while (flag != 0) {
                        ca.await();
                    }
                    //干活
                    System.out.print("A");

                    //通知，调用别的 线程的 condition 唤醒别的线程
                    flag = 1;
                    cb.signal();
                    // 解锁
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }


        }

        public void printB() {

            for (int i = 0; i < n; i++) {
                lock.lock();
                try {
                    while (flag != 1) {
                        cb.await();
                    }
                    System.out.print("B");
                    flag = 0;
                    ca.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }

    }


    public static void main(String[] args) {

        // 传入 打印的 AB 节 的个数
        Resource rs = new Resource(9);

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

       try{ TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e){e.printStackTrace();}
        System.out.println();
    }
}
