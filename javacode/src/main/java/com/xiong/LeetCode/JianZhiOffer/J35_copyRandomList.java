package com.xiong.LeetCode.JianZhiOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/18 18:40
 * @description：   面试题35. 复杂链表的复制
 * @modified By：
 * @version: $
 */
public class J35_copyRandomList {

    public Node copyRandomList(Node head) {

        if (head == null){
            return null;
        }

        //1 复制

        Node cur = head;
        while(cur != null){
            Node next = cur.next;
            Node copy = new Node(cur.val);
            cur.next = copy;
            copy.next = next;
            //下一个
            cur = next;
        }

        //2 复制random指向
        cur = head;

        while(cur != null){
            Node random = cur.random;
            Node copy = cur.next;
            if (random != null){
                copy.random = random.next;
            }
            //下一个
            cur = copy.next;
        }
        //3 拆分
        cur = head;
        Node newHead = null;
        while(cur.next != null){
            Node next = cur.next;
            if (newHead == null){
                newHead = next;
            }
            // 每次只拆一个
            cur.next = next.next;
            //下一个
            //每一个都要遍历到
            cur = next;
        }

        return newHead;

    }

    class Node{
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

    }
}
