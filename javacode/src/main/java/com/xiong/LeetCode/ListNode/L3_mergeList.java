package com.xiong.LeetCode.ListNode;

import com.xiong.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/27 14:16
 * @description： 合并有序链表
 * @modified By：
 * @version: $
 */
public class L3_mergeList {
    /**
     * @author: xiongcong
     * @Date: 2020/2/27 14:17
     * @Description: 递归实现较简单 这里非递归
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode preHead = new ListNode(0);
        ListNode curNode = preHead;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {

                curNode.next = l1;
                curNode = curNode.next;
                l1 = l1.next;
            } else {
                curNode.next = l2;
                curNode = curNode.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            curNode.next = l1;
        }
        if (l2 != null) {
            curNode.next = l2;
        }
        return preHead.next;

    }
}
