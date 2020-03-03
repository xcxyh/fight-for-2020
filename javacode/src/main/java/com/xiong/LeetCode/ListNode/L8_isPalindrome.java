package com.xiong.LeetCode.ListNode;

import com.xiong.JZOffer.ListNode;


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
        //先找到中点 翻转后半部分 再判断 两部分是否相等

        if (head == null || head.next == null ){
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp = slow.next; //temp 为后半部分

        ListNode reverseSec = reverse(slow.next);

        return isSame(head,reverseSec);

    }
    /**
     *  @author: xiongcong
     *  @Date: 2020/3/3 13:58
     *  @Description: 翻转链表
     */
    private ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    /**
     *  @author: xiongcong
     *  @Date: 2020/3/3 13:58
     *  @Description: 判断是否相等
     */
    private boolean isSame(ListNode node1,ListNode node2){
        if (node1 == null && node2 == null){
            return true;
        }
        if (node1 == null || node2 == null){
            return false;
        }
        //由于node2 长度为node1 的一半 只判断node2是否为空
        while (node2 != null){

            if (node1.val != node2.val){
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;


    }

}
