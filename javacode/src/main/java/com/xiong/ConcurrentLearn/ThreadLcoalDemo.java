package com.xiong.ConcurrentLearn;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/5 18:31
 * @description：
 * @modified By：
 * @version: $
 */
public class ThreadLcoalDemo {


    public static void main(String[] args) {
        ThreadLocal<String> threadLocal =  new ThreadLocal<>();
        ThreadLocal<String> threadLocal2 =  new ThreadLocal<>();
        threadLocal.set("xi");
        threadLocal2.set("ha");

        System.out.println(threadLocal.get());
        System.out.println(threadLocal2.get());
    }
}
