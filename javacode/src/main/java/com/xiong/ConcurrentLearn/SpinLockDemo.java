package com.xiong.ConcurrentLearn;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/13 15:56
 * @description：  手写自旋锁
 * @modified By：
 * @version: $
 */
public class SpinLockDemo {

     //使用原子引用的 CAS 实现
    AtomicReference<Thread>  atomicReference = new AtomicReference<>();

    public void mylock(){
        //获取当前线程
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "\t started");
        //自旋
        while (! atomicReference.compareAndSet(null, thread)){

        }
    }

    public void myunlock(){
        //获取当前线程
        Thread thread = Thread.currentThread();
        //释放
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName() + "\t invoke myunlock");
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();

      new Thread(() -> {
          spinLockDemo.mylock();
          try{TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e){e.printStackTrace();}
          spinLockDemo.myunlock();
      },"t1").start();

      //暂停一秒 让 t1先获得锁
        try{ TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e){e.printStackTrace();}

      new Thread(() -> {
        spinLockDemo.mylock();
        try{ TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e){e.printStackTrace();}
        spinLockDemo.myunlock();
      },"t2").start();



    }

}
