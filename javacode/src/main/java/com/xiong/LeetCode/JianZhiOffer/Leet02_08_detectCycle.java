package com.xiong.LeetCode.JianZhiOffer;

import com.xiong.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/16 15:50
 * @description：  面试题 02.08. 环路检测
 * @modified By：
 * @version: $
 */
public class Leet02_08_detectCycle {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null; // 无环则返回null
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                fast = head;
                while(slow != fast){
                    slow =slow.next;
                    fast= fast.next;
                }
                return slow;
            }

        }
        return null; // 无环则返回null
    }
}
