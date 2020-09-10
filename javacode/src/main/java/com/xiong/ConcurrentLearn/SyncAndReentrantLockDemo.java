package com.xiong.ConcurrentLearn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/18 13:43
 * @description： synchronized 和 Lock 有什么区别？
 *
 * 1 原始构成：
 * synchronized 是关键字，属于JVM 层面 monitorenter 和 monitorexit
 * 底层是通过monitor对象来完成，其实wait 和 notify 等方法也依赖于 monitor 对象
 * 而且只有在 同步代码块和同步方法中才能调用 wait和 notify
 * lock 是具体接口，是（java.util.concurrent.locks.Lock ）api 层面
 *
 * 2 使用方法:
 * synchronized 不需要手动释放锁 ，当 synchronized 代码运行完成后系统自动让线程释放对锁的占用
 * Lock 的实现类ReentrantLock 需要用户手动释放锁（unlock），若没有主动释放锁，会造成死锁现象
 *
 * 3 等待是否可中断：
 * synchronized 不可以被中断  要么抛出异常 要么正常完成
 * Lock 的实现类ReentrantLock 可中断 ：
 *   * 1 设置超时方法 trylock （long timeout, TimeUnit unit）
 *   * 2 lockinterruptibly() 放入代码块中，调用interrupt（）方法可中断
 *
 * 4 加锁是否公平
 * synchronized 是一种可重入的 非公平锁
 * Lock 的实现类ReentrantLock 也是可重入锁，但是 他既可以是 非公平的 也可以是公平的，
 * 看传入构造方法的参数
 *
 * 5 锁绑定多个 condition 可唤醒指定线程
 * synchronized 没有 condition  只能通过 notify 或者 notifyAll 随机唤醒一个线程或全部线程
 * Lock 的实现类ReentrantLock 可使用condition 完成分组唤醒 需要唤醒的线程
 *
 * @modified By：
 * @version: $
 */



public class SyncAndReentrantLockDemo {
   static class ShareResource{

        private int number = 1; // 标志位

        private Lock lock = new ReentrantLock();
        private Condition con1 = lock.newCondition();
        private Condition con2 = lock.newCondition();
        private Condition con3 = lock.newCondition();


        public void print5(){
            // 哪个线程调用该方法 哪个线程就拥有这个 condition
            //即这个 condition 就控制哪个线程
            lock.lock();
            try{
                //判断
                while (number != 1){
                    con1.await();
                }
                //do
                for (int i = 1; i <=5 ; i++) {
                    System.out.println(Thread.currentThread().getName() + "\t" + i);
                }
                //通知
                number =2;
                con2.signal();
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        }

        public void print10(){
            lock.lock();
            try{
                //判断
                while (number != 2){
                    con2.await();
                }
                //do
                for (int i = 1; i <=10 ; i++) {
                    System.out.println(Thread.currentThread().getName() + "\t" + i);
                }
                //通知
                number =3;
                con3.signal();
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        }

        public void print15(){
            lock.lock();
            try{
                //判断
                while (number != 3){
                    con3.await();
                }
                //do
                for (int i = 1; i <=15 ; i++) {
                    System.out.println(Thread.currentThread().getName() + "\t" + i);
                }
                //通知
                number =1;
                con1.signal();
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        }

    }
    /**
     *  @author: xiongcong
     *  @Date: 2020/3/18 14:06
     *  @Description: 题目：多线程之间按顺序调用 实现A -> B -> C 三个线程启动，要求：
     *  AA 线程打印5次后 BB线程打印10次 CC 线程打印15次
     *  然后回到AA 线程。。。
     *  AA 线程打印5次后 BB线程打印10次 CC 线程打印15次
     *  。。。
     *  重复10次
     */
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();

        new Thread(() -> {
           try {
               for (int i = 0; i < 10; i++) {
                   shareResource.print5();
               }
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"AA").start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    shareResource.print10();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"BB").start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    shareResource.print15();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"CC").start();
    }
}
