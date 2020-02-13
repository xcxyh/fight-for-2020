package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/2 11:48
 * @description： 输入一个链表，输出该链表中倒数第k个结点。
 *
 * 双指针法 ：p1 和p2
 * 1 先p1移动k步
 * 2然后 p1 和p2 同时移动  当p1 移动到链表尾部时，p2 位置即为倒数第k个结点
 * @modified By：
 * @version: $
 */
public class J22_FindLastKNode {

    public static void main(String[] args) {
        ListNode As = new ListNode(1);
        ListNode A = new ListNode(2,As);
        ListNode B = new ListNode(2, A);
        ListNode C = new ListNode(4, B);
        ListNode D = new ListNode(5, C);
        ListNode E = new ListNode(6, D);
        ListNode F = new ListNode(7, E);
        System.out.println(findKthToTail(As,2).data);
    }

    public static ListNode findKthToTail(ListNode head,int k) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = head;

        for (int i = 0; i <k ; i++) {
            p1 = p1.next;
        }
        while(p1 != null){
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;
    }
}
