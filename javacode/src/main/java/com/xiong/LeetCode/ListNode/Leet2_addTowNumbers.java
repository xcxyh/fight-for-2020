package com.xiong.LeetCode.ListNode;

import com.xiong.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/17 19:46
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet2_addTowNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }

        ListNode head = new ListNode(-1);
        ListNode cur =head;
        int carry = 0;
        while(l1 != null || l2 != null){
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;

            int sum = a + b + carry;
            carry = sum /10;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }

        if (carry != 0){
            cur.next = new ListNode(1);
        }
        return head.next;
    }
}
