package com.xiong.Cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/14 11:01
 * @description： java  可以继承 linkedHashMap 实现 LRU 缓存
 * @modified By：
 * @version: $
 */
public class LRUCache_LinkedHashMap extends LinkedHashMap<Integer,Integer> {

    private int capacity;
    public LRUCache_LinkedHashMap(int capacity) {
        super(capacity,0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        super.put(key,value);
    }
    /**
     *  @author: xiongcong
     *  @Date: 2020/4/5 11:45
     *  @Description: 覆写 removeEldestEntry 方法即可
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return super.size() > capacity;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */