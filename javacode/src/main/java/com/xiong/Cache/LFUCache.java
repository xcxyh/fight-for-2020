package com.xiong.Cache;

import java.util.*;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/5 10:52
 * @description： leet460 最不常用 缓存淘汰 Least Frequency Used   ( HARD )
 *  O(1) 时间复杂度  推荐
 * @modified By：
 * @version: $
 */

public class LFUCache {

    class Node {
        int key; // 键
        int value; //值
        int frequency = 1; // 使用频率

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    private Map<Integer, Node> cache;  // 存储缓存的内容
    private Map<Integer, LinkedHashSet<Node>> freqMap; // 存储每个频次对应的双向链表
    private int size;
    private int capacity;
    private int min; // 存储当前最小频次

    public LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        freqInc(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            freqInc(node);
        } else {
            if (size == capacity) {
                Node deadNode = removeNode();
                cache.remove(deadNode.key);
                size--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            size++;
        }
    }

    //关键方法  更新 频次 map
    private void freqInc(Node node) {
        // 从原freq对应的链表里移除, 并更新min
        int freq = node.frequency;
        LinkedHashSet<Node> set = freqMap.get(freq);
        set.remove(node);
        if (freq == min && set.size() == 0) {
            min = freq + 1;
        }
        // 加入新freq对应的链表
        node.frequency++;
        LinkedHashSet<Node> newSet = freqMap.get(freq + 1);
        if (newSet == null) {
            newSet = new LinkedHashSet<>();
            freqMap.put(freq + 1, newSet);
        }
        newSet.add(node);
    }

    private void addNode(Node node) {
        LinkedHashSet<Node> set = freqMap.get(1);
        if (set == null) {
            set = new LinkedHashSet<>();
            freqMap.put(1, set);
        }
        set.add(node);
        min = 1;
    }

    private Node removeNode() {
        LinkedHashSet<Node> set = freqMap.get(min);
        Node deadNode = set.iterator().next(); //删除set 中 第一个元素
        set.remove(deadNode);
        return deadNode;
    }

}


