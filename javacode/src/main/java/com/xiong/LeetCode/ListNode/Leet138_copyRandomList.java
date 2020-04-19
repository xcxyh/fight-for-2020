package com.xiong.LeetCode.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/18 10:42
 * @description：
 * @modified By：
 * @version: $
 */

class Node{
    int val;
    Node next;
    Node random;
    Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("val：");
        sb.append(this.val);
        //临时节点，从首节点开始
        Node temp = this.next;

        while (temp != null) {

            sb.append(" -> ");
            sb.append(temp.val);
            //继续下一个
            temp = temp.next;
        }
        //sb.append("\n");

        return sb.toString();
    }
}

public class Leet138_copyRandomList {

    public static void main(String[] args) {
        Node head = new Node(7);
        Node l1 = new Node(13);
        Node l2 = new Node(11);
        Node l3 = new Node(10);
        Node l4 = new Node(1);

        head.next = l1;
        head.random = null;
        l1.next = l2;
        l1.random = head;
        l2.next = l3;
        l2.random = l4;
        l3.next = l4;
        l3.random = l2;
        l4.random = head;

        Node newHead = copyRandomList(head);
        System.out.println(newHead);
    }


    public static Node copyRandomList(Node head) {
        if(head == null ){
            return head;
        }

        //复制每个节点
        Node cur = head;
        while(cur != null ){
            Node node = new Node(cur.val);
            Node next = cur.next;
            cur.next = node;
            node.next = next;
            cur = node.next;
        }
        cur = head;

        //复制random 指向  注意为null 情况
        while(cur != null){
            Node clone = cur.next;
            if (cur.random != null) {
                clone.random = cur.random.next;
            }
            cur = clone.next;
        }

        //拆分
        cur = head;
        Node newHead = head.next;
        while(cur.next != null){
            Node next = cur.next;
            cur.next = next.next;
            cur = next;
        }

        return newHead;
    }
}
