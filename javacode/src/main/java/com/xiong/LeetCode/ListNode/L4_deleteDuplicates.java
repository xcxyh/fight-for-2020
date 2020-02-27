package com.xiong.LeetCode.ListNode;

import com.xiong.JZOffer.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/27 15:08
 * @description： 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * @modified By：
 * @version: $
 */
public class L4_deleteDuplicates {


    /**
     *  @author: xiongcong
     *  @Date: 2020/2/27 15:46
     *  @Description: 递归
     */
    public ListNode deleteDuplicatesR(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }
        head.next = deleteDuplicatesR(head.next);
        return head.data == head.next.data ? head.next : head;

    }

    //  ...
    public ListNode deleteDuplicates(ListNode head) {

            if (head == null || head.next == null){
                return head;
            }

            ListNode temp = head;

            while (temp != null && temp.next != null){

                ListNode next = temp;

                while (next.next != null){

                   if (next.next.data == temp.data) {
                       next.next = next.next.next;
                   }else {
                       next =next.next;
                   }

                }

                temp = temp.next;
            }

        return temp;
    }


}
