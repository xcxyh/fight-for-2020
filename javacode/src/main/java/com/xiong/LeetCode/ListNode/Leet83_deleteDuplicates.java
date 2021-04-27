package com.xiong.LeetCode.ListNode;

import com.xiong.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/27 15:08
 * @description： 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * @modified By：
 * @version: $
 */
public class Leet83_deleteDuplicates {


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            // 与 82 唯一的区别
            return deleteDuplicates(head);
        }else {
            head.next = deleteDuplicates(head.next);

            return head;
        }
    }

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
        return head.val == head.next.val ? head.next : head;

    }



}
