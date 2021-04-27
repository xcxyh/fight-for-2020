package com.xiong.LeetCode.HashMap;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/3/14 11:17
 * @description：  设计题   706. 设计哈希映射
 * @modified By：
 * @version: $
 */
public class Leet706_MyHashMap {private static int size = 769;
    private LinkedList<Node>[] data;
    class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    /** Initialize your data structure here. */
    public Leet706_MyHashMap() {
        data = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            data[i] = new LinkedList<>();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {

        LinkedList<Node> list = data[hash(key)];

        for (Node cur : list) {
            if (cur.key == key) {
                cur.value = value;
                return;
            }
        }

        list.offerLast(new Node(key, value));

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        LinkedList<Node> list = data[hash(key)];

        for (Node cur : list) {
            if (cur.key == key) {
                return cur.value;
            }
        }

        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        LinkedList<Node> list = data[hash(key)];
        Iterator<Node> it = list.iterator();
        // 这里不可以用foreach
        while (it.hasNext()) {
            Node cur = it.next();
            if (cur.key == key) {
                it.remove();
                return;
            }
        }
    }

    private int hash(int key) {
        return key % size;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */