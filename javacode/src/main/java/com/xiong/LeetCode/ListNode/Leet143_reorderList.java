package com.xiong.LeetCode.ListNode;

import com.xiong.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/10/20 10:26
 * @description： 143. 重排链表
 * @modified By：
 * @version: $
 */
public class Leet143_reorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null){
            return;
        }

        // 拆分

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 后半部 翻转
        ListNode half = reverse(slow.next);
        slow.next = null;
        // 合并
        ListNode cur = head;
        while (cur != null && half != null){
            ListNode next = cur.next;
            ListNode halfnext = half.next;

            cur.next = half;
            half.next = next;

            cur = next;
            half = halfnext;

        }


    }


    private ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode pre = null;

        while (head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
