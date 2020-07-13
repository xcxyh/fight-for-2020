package com.xiong.LeetCode.ListNode;

import com.xiong.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/27 13:50
 * @description： 链表翻转
 * @modified By：
 * @version: $
 */
public class L2_reverseList {
    /**
     *  @author: xiongcong
     *  @Date: 2020/2/27 13:56
     *  @Description: 头插法
     */
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseListR(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode temp = head.next;
        ListNode newNode = reverseListR(temp);
        temp.next = head; //反向
        head.next = null;

        return newNode;

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        traverse(new L2_reverseList().reverseListR(listNode));
    }

    public static void traverse(ListNode head) {

        System.out.print("data：" + head.val);
        //临时节点，从首节点开始
        ListNode temp = head.next;

        while (temp != null) {

            System.out.print(" -> " + temp.val);

            //继续下一个
            temp = temp.next;
        }
        System.out.println();//换行
    }

}
