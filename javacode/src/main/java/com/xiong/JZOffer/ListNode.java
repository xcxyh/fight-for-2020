package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2019/12/7 11:25
 * @description： 单链表
 * @modified By：
 * @version: $
 */
public class ListNode {

    public ListNode next;

    public int val;

    public ListNode head;

    public ListNode(int x) {
        this.val = x;
    }  //赋值链表的值
    public ListNode(int x, ListNode pre) {
        pre.next = this;
        this.val = x;

    }
}
