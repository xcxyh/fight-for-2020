package com.xiong.LeetCode.ListNode;

import com.xiong.ListNode;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/1/3 9:55
 * @description： 86. 分隔链表
 * @modified By：
 * @version: $
 */
public class Leet86_partition {

    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(-1);
        ListNode right =  new ListNode(-1);
        ListNode leftHead = left;
        ListNode rightHead = right;

        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = null;
            if (cur.val < x) {
                left.next = cur;
                left = left.next;
            }else{
                right.next = cur;
                right = right.next;
            }
            cur = next;
        }
        left.next = rightHead.next;
        return leftHead.next;
    }
}
