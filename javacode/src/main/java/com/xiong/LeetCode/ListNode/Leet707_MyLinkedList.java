package com.xiong.LeetCode.ListNode;

import com.xiong.JZOffer.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/14 19:02
 * @description：  707 设计链表
 * @modified By：
 * @version: $
 */
public class Leet707_MyLinkedList {
    //ac 了
    public static void main(String[] args) {
        Leet707_MyLinkedList obj = new Leet707_MyLinkedList();
        obj.addAtHead(1);
        obj.addAtTail(3);
        obj.addAtIndex(1,2);   //链表变为1-> 2-> 3
        System.out.println(obj.get(1));//返回2
        obj.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(obj.get(1));
    }


    private ListNode pre = null;//链表的头节点
    private int size = 0; // 记录链表的长度

    /**
     * Initialize your data structure here.
     */
    public Leet707_MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        //index 从 0 开始
        if (index > size - 1) {
            return -1;
        }

        ListNode cur = pre;
        while (cur != null && index-- > 0) {
            cur = cur.next;
        }
        return cur == null ? -1 : cur.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        // 头插法
        node.next = pre;
        pre = node;
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        ListNode cur = pre;
        //遍历到尾部
        while (cur.next != null) {
            cur = cur.next;
        }
        //插入
        cur.next = node;
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else if (index < size) {
            ListNode cur = pre;
            //遍历找到 index-th node 的前一个节点 即cur
            while (--index > 0) {
                cur = cur.next;
            }
            // cur 为 前一个节点  cur -> newNode -> index-th node
            ListNode node = new ListNode(val);
            ListNode next = cur.next;
            cur.next = node;
            node.next = next;
            size++;
        }


    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        //中间节点
        if (index > 0 && index < size) {
            ListNode cur = pre;
            ListNode ppp = null; //记录 cur 的前一个节点
            while (index-- > 0) {
                ppp = cur;
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            ppp.next = next;
            size--;
        } else if (index == 0) {
            pre = pre.next;
            size--;
        }

    }
}
// 这里用的 我自己创建的 所以屏蔽这个
/*class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}*/
