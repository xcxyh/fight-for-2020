package com.xiong.LeetCode.HashMap;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/3/13 9:47
 * @description：   链地址法 实现  hashset
 * @modified By：
 * @version: $
 */
public class Leet705_MyHashSet {
    private LinkedList<Integer>[] bucket = new LinkedList[769];
    /** Initialize your data structure here. */
    public Leet705_MyHashSet() {
        for (int i = 0; i < 769; i++) {
            bucket[i] = new LinkedList<>();
        }
    }

    public void add(int key) {
        LinkedList<Integer> list = bucket[hash(key)];

        Iterator<Integer> it = list.iterator();

        while (it.hasNext()) {
            Integer ele = it.next();
            if (ele.intValue() == key) {
                return;
            }
        }

        list.offerLast(key);
    }

    public void remove(int key) {
        LinkedList<Integer> list = bucket[hash(key)];

        Iterator<Integer> it = list.iterator();

        while (it.hasNext()) {
            Integer ele = it.next();
            if (ele.intValue() == key) {
                it.remove();
                return;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        LinkedList<Integer> list = bucket[hash(key)];

        Iterator<Integer> it = list.iterator();

        while (it.hasNext()) {
            Integer ele = it.next();
            if (ele.intValue() == key) {
                return true;
            }
        }
        return false;
    }

    private static int hash(int key){
        return key % 769;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */