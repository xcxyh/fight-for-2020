package com.xiong.Cache;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/21 11:54
 * @description：
 * @modified By：
 * @version: $
 */

class CacheNode {
    int key;
    int val;

    CacheNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class LRUCache_LinkedListAndMap {

    private HashMap<Integer, CacheNode> map;
    private LinkedList<CacheNode> cacheList;
    private int cap;
    public LRUCache_LinkedListAndMap(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
        this.cacheList = new LinkedList<>();
    }

    public int get(int key) {
        if(! map.containsKey(key)){
            return -1;
        }
        CacheNode node= map.get(key);
        int val = node.val;
        // 使用 put 方法让 node 到最前面
        put(key, val);
        return val;
    }

    public void put(int key, int value) {
        //构造节点
        CacheNode node = new CacheNode(key, value);

        if (map.containsKey(key)){
            //先从map中得到旧的 再 删除 cacheList 中的旧的，
            CacheNode oldNode = map.get(key);
            cacheList.remove(oldNode);
            //新的node 插入到头部
            cacheList.addFirst(node);
            //更新映射
            map.put(key, node);
        }else{

            if (cacheList.size() == cap){
                //删除最后一个
               CacheNode lastNode = cacheList.removeLast();
                //map也要同步删除
                map.remove(lastNode.key);
            }

            //新的node 插入到头部
            cacheList.addFirst(node);
            //更新映射
            map.put(key, node);
        }
    }

    public static void main(String[] args) {

    }
}
