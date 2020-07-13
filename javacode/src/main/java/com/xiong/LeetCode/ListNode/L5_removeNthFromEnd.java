package com.xiong.LeetCode.ListNode;

import com.xiong.ListNode;

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
        if (head == null || head.next == null){
            return null;
        }
        //双指针找到链表中倒数第n 个节点 然后删除
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = head;
        while(n-- > 0){
            fast = fast.next;
        }
        // 要删除的节点为头节点时
        if(fast == null){
            return head.next;
        }

        while(fast != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        //删除
        ListNode next = slow.next;
        slow.next = null;
        pre.next = next;
        return head;

    }


}
