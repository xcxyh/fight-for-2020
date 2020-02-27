package com.xiong.LeetCode.ListNode;

import com.xiong.JZOffer.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/27 15:49
 * @description： 删除倒数第k个节点
 * <p>
 * 双指针法
 * @modified By：
 * @version: $
 */
public class L5_removeNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode index1 = head;
        ListNode index2 = head;

        for (int i = 0; i < n; i++) {
            index1 = index1.next;
        }
        //必须判断
        if(index1 == null){
            return head.next;
        }
        while (index2.next != null) {

            if (index1.next == null) {
                index2.next = index2.next.next;
                break;
            }
            index2 = index2.next;
            index1 = index1.next;
        }
        return head;


    }
}
