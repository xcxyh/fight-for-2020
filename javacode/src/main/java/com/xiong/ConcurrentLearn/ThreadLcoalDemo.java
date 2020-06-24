package com.xiong.ConcurrentLearn;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/5 18:31
 * @description：
 * @modified By：
 * @version: $
 */
public class ThreadLcoalDemo {

    private static final ThreadLocal<String> threadLocal =  new ThreadLocal<>();
    public static void main(String[] args) {
        threadLocal.set("I am  main");
        System.out.println(threadLocal.get());

        new Thread(() -> threadLocal.set("I am A"),"A").start();

        new Thread(() -> threadLocal.set("I am B"),"B").start();
    }
}
