package com.xiong.LeetCode.ListNode;

import com.xiong.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/16 15:21
 * @description：   25. K 个一组翻转链表
 * @modified By：
 * @version: $
 */
public class Leet25_reverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null){
            return null;
        }

        ListNode a = head;
        ListNode b = head;
        int i = 0;
        while(i < k){
            if(b == null){
                return head;  // 直接返回  不反转！！
            }
            b = b.next;
            i++;
        }

        ListNode newHead = reverse(a, b);

        a.next = reverseKGroup(b, k);

        return newHead;

    }
    // [head, tail)  不包括 右端点
    private ListNode reverse(ListNode head, ListNode tail){
        ListNode pre = null;
        while(head != tail){ // 条件
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }
}
