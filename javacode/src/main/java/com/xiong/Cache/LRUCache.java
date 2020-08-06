package com.xiong.Cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/6 11:46
 * @description： 自定义 双向链表
 * @modified By：
 * @version: $
 */
public class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        DLinkedNode(){}

        DLinkedNode(int key , int value){
            this.key = key;
            this.value = value;
        }
    }


    private Map<Integer, DLinkedNode> cacheMap = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key)){
            return -1;
        }
        DLinkedNode node = cacheMap.get(key);

        // 移动到最前面
        moveToHead(node);

        return node.value;

    }

    public void put(int key, int value) {
        DLinkedNode node = new DLinkedNode(key, value);

        if (cacheMap.containsKey(key)){

            // 从 map 中获取旧node 删掉
            DLinkedNode oldNode = cacheMap.get(key);

            removeNode(oldNode);
            // 添加新的
            addToHead(node);
            // 同步 map
            cacheMap.put(key, node);

        }else{

            if (size == capacity){
                DLinkedNode last = tail.prev;
                // 从map中删除
                cacheMap.remove(last.key);
                // 删除 尾节点
                removeNode(last);
                --size;
            }

            // 添加
            addToHead(node);
            // 同步 map
            cacheMap.put(key, node);
            size++;
        }

    }

    private void addToHead(DLinkedNode node) {
        DLinkedNode next = head.next;
        head.next = node;
        node.next = next;
        node.prev = head;
        next.prev = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

}
