package com.xiong.ConcurrentLearn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/16 20:16
 * @description： 生产者消费者 传统实现
 * <p>
 * 多线程：
 * 线程   操作（通过资源类的方法） 资源类
 * 判断   生产    通知
 * 防止虚假唤醒 （ 判断要用 while  不能用 if  ）
 * @modified By：
 * @version: $
 */
class ShareData { //资源类
    private Integer number = 0;
    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    //生产
    public void increment() {

        lock.lock();
        try {
            //有就不生产 否则生产
            while (number != 0) { // 多线程必须用 while 判断  预防 虚假唤醒 的情况

                condition.await();
            }
            //生产
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //通知
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //消费
    public void decrement() {

        lock.lock();
        try {
            //有就消费 没有就不消费 等待
            while (number == 0) { // 多线程必须用 while 判断  预防 虚假唤醒 的情况

                condition.await();
            }
            //消费
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //通知
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class ProdConsumer_TraditionDemo {

    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "CC").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "DD").start();

    }
}
