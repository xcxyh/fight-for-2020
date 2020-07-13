package com.xiong.LeetCode.JianZhiOffer;

import com.xiong.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/3 10:47
 * @description：
 * @modified By：
 * @version: $
 */
public class J18_deleteNode {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null){
            return null;
        }

        while(head != null && head.val == val){
            head = head.next;
        }

        ListNode pre = null;
        ListNode cur = head;

        while(cur != null){
            ListNode next = cur.next;
            if (cur.val == val){
                pre.next = next;
                cur.next = null;
            }
            pre = cur;
            cur = next;
        }
        return head;
    }
}
