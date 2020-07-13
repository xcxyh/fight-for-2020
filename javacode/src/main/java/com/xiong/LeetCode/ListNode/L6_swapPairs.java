package com.xiong.LeetCode.ListNode;

import com.xiong.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/28 15:54
 * @description：
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
 * @modified By：
 * @version: $
 */
public class L6_swapPairs {

    //中等
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next ==null){
            return head;
        }
        ListNode next = head.next; //记录 head 的下一节点
        head.next = swapPairs(next.next); //head 指向 交换后的子链
        next.next = head; // next 指向 head

        return next;
    }

}
