package com.xiong.LeetCode.ListNode;

import com.xiong.JZOffer.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/16 18:07
 * @description： 328. 奇偶链表  自创解法
 * @modified By：
 * @version: $
 */
public class Leet328_oddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null){
            return head;
        }

        //得到尾节点 遍历到偶数位置的节点就将他删除 然后加到尾部 即可
        ListNode tail = head;
        int size = 1;
        while(tail.next != null){
            tail = tail.next;
            size++;
        }

        ListNode cur = head;
        ListNode pre =null;
        int i = 1;
        while(size-- > 0){

            ListNode next =  cur.next;
            if (i % 2 == 0){
                //删除
                pre.next = next;
                cur.next = null;
                //加到尾部
                tail.next = cur;
                tail = cur;
            }else{
                pre = cur;
            }

            cur = next;
            i++;
        }
        return head;

    }
}
