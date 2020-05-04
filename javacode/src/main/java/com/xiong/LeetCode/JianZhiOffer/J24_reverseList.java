package com.xiong.LeetCode.JianZhiOffer;

import com.xiong.JZOffer.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/3 11:55
 * @description：  24 翻转链表
 * @modified By：
 * @version: $
 */
public class J24_reverseList {

    public ListNode reverseList(ListNode head) {
        return reverseRe(head);
    }
    //非递归 头插法
    private ListNode reverseNonRe(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode pre =null;
        while(head != null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
    //递归
    private ListNode reverseRe(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode next = head.next;
        ListNode newNode = reverseRe(next);
        next.next = head;
        head.next = null;
        return newNode;
    }
}
