package com.xiong.LeetCode.ListNode;

import com.xiong.JZOffer.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/16 17:44
 * @description： 203. 移除链表元素
 * @modified By：
 * @version: $
 */
public class Leet203_removeElements {


    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }
        // 要删除的节点为头节点时  注意用while
        while ( head != null && head.val == val){
            head = head.next;
        }
        ListNode cur = head;

        ListNode pre= null;
        while(cur != null){
            // 先记录 next
            ListNode next = cur.next;
            if (cur.val == val){
                //删除
                pre.next = next;
                cur.next = null;
            }else{// 否则 就 将当前节点 置为 pre
                pre = cur;
            }
            //检测下一个节点
            cur = next;

        }


        return head;
    }
}
