package com.xiong.ConcurrentLearn;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/14 11:01
 * @description： java利用泛型和 linkedHashMap 实现 LRU 缓存
 * @modified By：
 * @version: $
 */
public class LRUCache<K,V> extends LinkedHashMap<K, V> implements Serializable {

    /**
     * 缓存默认大小
     */
    public static final int DEFAULT_CAPASITY = 20;
    /**
     * 缓存实际大小
     */
    public static int CACHE_CAPASITY = DEFAULT_CAPASITY;
    /**
     * 线程同步锁 非公平 可重入锁
     */
    private static final Lock lock = new ReentrantLock();
    public LRUCache() {
        super(DEFAULT_CAPASITY);
        CACHE_CAPASITY = DEFAULT_CAPASITY;
    }
    public LRUCache(int size) {
        super(size);
        CACHE_CAPASITY = size;
    }
    /*
     * 清空緩存
     *
     * @see java.util.LinkedHashMap#clear()
     */
    @Override
    public void clear() {
        try {
            lock.lock();
            super.clear();
        } finally {
            lock.unlock();
        }
    }
    /*
     * 判断是否包含该对象
     *
     * @see java.util.LinkedHashMap#containsValue(java.lang.Object)
     */
    @Override
    public boolean containsValue(Object value) {
        try {
            lock.lock();
            return super.containsValue(value);
        } finally {
            lock.unlock();
        }
    }
    /*
     * 从缓存中查询对象
     *
     * @see java.util.LinkedHashMap#get(java.lang.Object)
     */
    @Override
    public V get(Object key) {
        try {
            lock.lock();
            return super.get(key);
        } finally {
            lock.unlock();
        }
    }
    /*
     * 是否删除最早未使用缓存对象  关键方法
     *
     * @see java.util.LinkedHashMap#removeEldestEntry(java.util.Map.Entry)
     */
    @Override
    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        try {
            lock.lock();
            return this.size() > CACHE_CAPASITY;
        } finally {
            lock.unlock();
        }
    }
    /*
     * 判断缓存中是否包含该key
     *
     * @see java.util.HashMap#containsKey(java.lang.Object)
     */
    @Override
    public boolean containsKey(Object key) {
        try {
            lock.lock();
            return super.containsKey(key);
        } finally {
            lock.unlock();
        }
    }
    /*
     * 判断缓存是否为空
     *
     * @see java.util.HashMap#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        try {
            lock.lock();
            return super.isEmpty();
        } finally {
            lock.unlock();
        }
    }
    /*
     * 放入缓存
     *
     * @see java.util.HashMap#put(java.lang.Object, java.lang.Object)
     */
    @Override
    public V put(K key, V value) {
        try {
            lock.lock();
            return super.put(key, value);
        } finally {
            lock.unlock();
        }
    }
    /*
     * 从缓存中删除
     *
     * @see java.util.HashMap#remove(java.lang.Object)
     */
    @Override
    public V remove(Object key) {
        try {
            lock.lock();
            return super.remove(key);
        } finally {
            lock.unlock();
        }
    }
    /*
     * 缓存大小
     *
     * @see java.util.HashMap#size()
     */
    @Override
    public int size() {
        try {
            lock.lock();
            return super.size();
        } finally {
            lock.unlock();
        }
    }




}
