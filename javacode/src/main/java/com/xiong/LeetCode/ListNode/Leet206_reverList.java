package com.xiong.LeetCode.ListNode;

import com.xiong.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/16 17:19
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet206_reverList {

    public ListNode reverseList(ListNode head) {
        return reverseNonRecursive(head);
    }


    //递归
    private ListNode reverseRecursive(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode next = head.next;
        ListNode newNode = reverseRecursive(next);
        next.next = head;
        head.next = null;

        return newNode;
    }


    //非递归
    private ListNode reverseNonRecursive(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        while(head != null ){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head =next;
        }
        return pre;
    }

}
