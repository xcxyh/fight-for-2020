package com.xiong.LeetCode.ListNode;

import com.xiong.ListNode;


/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/2 16:42
 * @description： 判断是否回文链表 ac
 * @modified By：
 * @version: $
 */
public class L8_isPalindrome {


    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);

        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        System.out.println(new L8_isPalindrome().isPalindrome(head));
    }

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
