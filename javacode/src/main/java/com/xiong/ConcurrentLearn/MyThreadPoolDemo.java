package com.xiong.ConcurrentLearn;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/18 18:29
 * @description：
 * @modified By：
 * @version: $
 */
public class MyThreadPoolDemo {

    public static void main(String[] args) {
        //构造器
        //ThreadPoolExecutor(int corePoolSize,
        //                              int maximumPoolSize,
        //                              long keepAliveTime,
        //                              TimeUnit unit,
        //                              BlockingQueue<Runnable> workQueue){}

        ExecutorService executorService =
                new ThreadPoolExecutor(
                5,
                10,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(100));


    }
}
