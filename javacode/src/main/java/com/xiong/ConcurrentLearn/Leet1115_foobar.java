package com.xiong.ConcurrentLearn;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/4 15:15
 * @description：  1115. 交替打印FooBar  这题会了 多线程 ok
 * @modified By：
 * @version: $
 */

class FooBar {
    private int n;
    private Lock lock = new ReentrantLock();
    private Condition fooCon = lock.newCondition();
    private Condition barCon = lock.newCondition();
    private volatile int flag = 1;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock(); //锁
            try{
                while(flag != 1){ // 判断
                    fooCon.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run(); //干活
                //通知
                flag = 2;
                barCon.signal();
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }


        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try{
                while(flag != 2){
                    barCon.await();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = 1;
                fooCon.signal();
            }catch(Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
public class Leet1115_foobar {


    public static void main(String[] args){
        FooBar fooBar = new FooBar(5);

        Runnable printFoo = () -> System.out.print("foo"); //lambda 表达式

        Runnable printBar = new Runnable() {
            @Override
            public void run() {
                System.out.println("bar");
            }
        };
        System.out.println("=====打印线程启动=====");
        new Thread(() -> {
            try {
                fooBar.foo(printFoo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Foo: ").start();

        try{ TimeUnit.MILLISECONDS.sleep(200); } catch (InterruptedException e){e.printStackTrace();}
        new Thread(() -> {
            try {
                fooBar.bar(printBar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Bar: ").start();

    }

}
