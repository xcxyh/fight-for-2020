package com.xiong.LeetCode.ListNode;

import com.xiong.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/18 14:40
 * @description： 61. 旋转链表
 * @modified By：
 * @version: $
 */
public class Leet61_rotateRight {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next =l2;
        l2.next =l3;
        l3.next =l4;
        l4.next =l5;

        System.out.println(rotateRight(l1, 2));
    }

    public ListNode rotateRightNew(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int n = 0;

        ListNode cur = head;

        while (cur != null) {
            cur = cur.next;
            n++;
        }
        k = k % n;

        int i = n - k;
        cur = head;
        while (i-- > 1) {
            cur = cur.next;
        }

        ListNode sec = cur.next;

        ListNode newFirst = reverse(head, sec);
        ListNode newSec = reverse(sec, null);

        head.next = newSec;

        return reverse(newFirst, null);
    }

    private ListNode reverse(ListNode head, ListNode tail){

        ListNode pre = null;

        while (head != tail) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }




    //ac
    // 先翻转前半部分 再翻转后半部分  连接之后  整体翻转 即可
    // 注意 k > size 的情况   应对 k % size 取余
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }
        int size = 0;
        ListNode cur = head;
        ListNode part1 = head; // 前半部分 大小为 size - k
        ListNode part2 = head; // 后半部分 大小为  k
        while(cur != null){
            cur = cur.next;
            size++;
        }
        cur = head;
        int count =size - k % size;
        while(--count >0){ // 这里注意 找到 分界点
            cur =cur.next;
        }
        part2 = cur.next;
        cur.next = null;
        part1 = reverse(part1);
        part2 = reverse(part2);
        cur = part1;
        while(cur.next != null){ // 遍历到 part1 尾部后 将 翻转后的part2 接上
            cur = cur.next;
        }
        cur.next = part2; //接上 part2

        return reverse(part1);

    }
    //头插法翻转
    private static ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        while(head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
