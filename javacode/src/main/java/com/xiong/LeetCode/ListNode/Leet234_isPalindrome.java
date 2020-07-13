package com.xiong.LeetCode.ListNode;

import com.xiong.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/16 18:33
 * @description： 234. 回文链表  简单
 * @modified By：
 * @version: $
 */
public class Leet234_isPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }

        // 快慢指针找到 中间点 然后 翻转后半部分， 最后比较值的大小
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow
        ListNode mid = reverse(slow);
        while(mid != null){
            if (head.val != mid.val){
                return false;
            }
            head = head.next;
            mid = mid.next;
        }
        return true;

    }
    //头插法 翻转链表
    private ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        while(head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
