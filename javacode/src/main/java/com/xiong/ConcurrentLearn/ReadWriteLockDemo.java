package com.xiong.ConcurrentLearn;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/13 16:50
 * @description： 读写锁
 * 多线程同时操作 一个资源类没有任何问题
 * 所以为了满足并发量
 * 读取共享资源应该可以同时进行
 * 但是
 * 如果有一个线程想去写共享资源来
 * 就不应该有其他线程可以对资源进行读或写
 * <p>
 * 小总结:
 * 读 读能共存
 * 读 写不能共存
 * 写 写不能共存
 * 写操作 原子+独占 整个过程必须是一个完成的统一整体 中间不允许被分割 被打断
 * @modified By：
 * @version: $
 */
public class ReadWriteLockDemo {


    static class MyCache {
        private Map<String, Object> map = new HashMap<>();
        private ReentrantReadWriteLock rwLocks = new ReentrantReadWriteLock();



        public void put(String key, Object value) {
            rwLocks.writeLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t 开始写入：" + key);
                map.put(key, value);
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t 写入完成");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                rwLocks.writeLock().unlock();
            }

        }

        public void get(String key) {
            rwLocks.readLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t 开始读取：");
                Object value = map.get(key);
                System.out.println(Thread.currentThread().getName() + "\t 读取完成: " + value);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                rwLocks.readLock().unlock();
            }

        }

        public void clearMap() {
            map.clear();
        }

    }

    public static void main(String[] args) {

        MyCache myCache = new MyCache();
        //写
        for (int i = 0; i < 5; i++) {
            final int index = i;  // lambda 表达式中 的要final 修饰
            new Thread(() -> {
                myCache.put(index + "", index + "");
            }, String.valueOf(i)).start();
        }
        //读
        for (int i = 0; i < 5; i++) {
            final int index = i;
            new Thread(() -> {
                myCache.get(index + "");
            }, String.valueOf(i)).start();
        }


    }
}
