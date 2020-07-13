package com.xiong.LeetCode.JianZhiOffer;

import com.xiong.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/29 12:09
 * @description： 剑指 Offer 22. 链表中倒数第k个节点
 * @modified By：
 * @version: $
 */
public class J22_getKthFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {


        // 双指针
        ListNode fast = head;

        while (fast != null && k-- > 0) {
            fast = fast.next;
        }

        ListNode slow = head;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
