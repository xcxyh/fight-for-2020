package com.xiong.Cache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/5 11:24
 * @description：  LFU 的 另一种实现  需要移动node  时间复杂度不为O(1)
 * @modified By：
 * @version: $
 */
class Node2 {
    int key; // 键
    int value; //值
    int frequency = 1; // 使用频率
    Node2 pre;
    Node2 next;

    public Node2() {
    }

    public Node2(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
public class LFUCache2 {
    public static void main(String[] args) {
        LFUCache2 cache = new LFUCache2( 2 /* capacity (缓存容量) */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回 1
        cache.put(3, 3);    // 去除 key 2
        cache.get(2);       // 返回 -1 (未找到key 2)
        cache.get(3);       // 返回 3
        cache.put(4, 4);    // 去除 key 1
        cache.get(1);       // 返回 -1 (未找到 key 1)
        cache.get(3);       // 返回 3
        cache.get(4);       // 返回 4
    }

    //map
    private Map<Integer, Node2> cache; // 缓存容器
    Node2 head; //双向链表 头部
    Node2 tail;//双向链表 尾部
    int capacity; //容量
    int size; //记录 cache 当前大小

    public LFUCache2(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.head = new Node2(); // 这两个头尾node 不含任何数据
        this.tail = new Node2();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node2 node = cache.get(key);
        if (node == null) {// 缓存中没有
            return -1;
        }
        //当前node 频率 + 1
        node.frequency++;
        moveToNewPosition(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        //若 cache 中有的话 取出 更新值
        Node2 node = cache.get(key);
        if (node != null) {
            node.value = value;
            node.frequency++;
            moveToNewPosition(node);
        } else { //cache 中没有
            //判断 容量是否满了
            if (size == capacity) {//满了 执行LFU 即删除 head 之后的那个节点 使用最少
                cache.remove(head.next.key);
                removeNode(head.next);
                size--;
            }
            //然后 执行插入
            Node2 newnode = new Node2(key, value);
            addNode(newnode);
            cache.put(key, newnode);
            size++;
        }

    }

    /**
     * @author: xiongcong
     * @Date: 2020/4/5 10:51
     * @Description: 移动当前node 到新位置 LFU 关键方法
     */
    private void moveToNewPosition(Node2 node) {
        Node2 nextNode = node.next; // nextNode
        removeNode(node);//删除当前node
        //向后找到 freq 比 node的 freq 大的节点
        while (nextNode.frequency <= node.frequency && nextNode != tail) { // frequency大的放链表在后面
            nextNode = nextNode.next;
        }
        //将node 插在 比 node的 freq 大的节点 的前面
        nextNode.pre.next = node; //pre -> node
        node.pre = nextNode.pre; // pre <- node
        node.next = nextNode; // node -> nextNode
        nextNode.pre = node; // node <- nextNode

    }

    private void addNode(Node2 node) {
        node.next = head.next; // node -> next
        node.pre = head; // head <- node
        head.next.pre = node; // node <- next
        head.next = node; // head -> node
        //插入到head 后面后 移动到合适的位置
        moveToNewPosition(node);
    }

    //删除当前node
    private void removeNode(Node2 node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
}

    /**
     * Your LFUCache object will be instantiated and called as such:
     * LFUCache obj = new LFUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
