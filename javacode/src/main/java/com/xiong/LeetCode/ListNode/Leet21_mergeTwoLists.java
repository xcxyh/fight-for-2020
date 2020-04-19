package com.xiong.LeetCode.ListNode;

import com.xiong.JZOffer.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/17 18:59
 * @description： 合并两个有序链表
 * @modified By：
 * @version: $
 */
public class Leet21_mergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }

        ListNode head = null;
        ListNode cur = null;
        while(l1 != null && l2 != null){
            if (head == null){
                if (l1.val <= l2.val){
                    head = l1;
                    l1 = l1.next;
                }else{
                    head = l2;
                    l2 = l2.next;
                }
                cur = head;
            }else{
                if (l1.val <= l2.val){
                    cur.next = l1;
                    l1 = l1.next;
                }else{
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
        }

        if (l1 != null){
            cur.next = l1;
        }
        if (l2 != null){
            cur.next = l2;
        }

        return head;
    }
}
