package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/4 14:47
 * @description： 翻转链表
 * @modified By：
 * @version: $
 */
public class J24_ReverseList {

    public static void main(String[] args) {
        ListNode As = new ListNode(1);
        ListNode A = new ListNode(2,As);
        ListNode B = new ListNode(3, A);
        ListNode C = new ListNode(4, B);
        ListNode D = new ListNode(5, C);
        ListNode E = new ListNode(6, D);
        ListNode F = new ListNode(7, E);
        //打印 翻转后的链表
        J18_DeleteNode_2.traversalList(reverseList(As));
    }

    /**
     *  @author: xiongcong
     *  @Date: 2020/2/4 14:48
     *  @Description: 头插法
     */
    public static ListNode reverseList(ListNode pHead){

        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode pre  = null;
        ListNode current = pHead;
        while (current != null){
            ListNode temp = current.next; //临时保存指向下个节点的指针
            current.next =pre; //当前指向 pre
            pre= current; // 当前 为 pre
            current =temp; // 下一个
        }
        return pre;
    }
    /**
     *  @author: xiongcong
     *  @Date: 2020/2/4 14:55
     *  @Description: 递归 ，较复杂
     */
    public static ListNode reverseList_2(ListNode pHead){
        //基线条件
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode next = pHead.next; //保存指向下个节点的指针
        pHead.next = null; //断开当前连接
        ListNode newHead  = reverseList_2(next);
        next.next = pHead; //反向
        return newHead;
    }

}
