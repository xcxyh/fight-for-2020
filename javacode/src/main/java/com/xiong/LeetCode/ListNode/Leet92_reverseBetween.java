package com.xiong.LeetCode.ListNode;

import com.xiong.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/12 11:33
 * @description：  92. 反转链表 II
 * @modified By：
 * @version: $
 */
public class Leet92_reverseBetween {

    public ListNode reverseBetween_diedai(ListNode head, int m, int n) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        // 让 cur 指向 m 位置的元素
        while(m > 1){
            pre = cur;
            cur = cur.next;
            m--;
            n--;
        }
        // 记录 con 为 前面分界点 第一个元素 ， tail 为第一个分界点 第二个元素
        ListNode con = pre; ListNode tail = cur;
        // 反转， 反转完之后 让 cur 指向 n 位置元素 后面的那个元素
        while(n-- > 0){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        if (con != null){
            con.next = pre;
        }else{
            head = pre;
        }

        tail.next = cur;

        return head;


    }



    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1){
            return reverseN(head, n);
        }

        head.next = reverseBetween(head.next, m-1, n - 1);
        return head;
    }
    // 完成翻转从 head 开始的 前 n 个节点
    private ListNode successor = null;// 记录 后面不反转 部分的 头节点  防止丢失
    private ListNode reverseN(ListNode head, int n){
        if (n == 1){
            successor = head.next;
            return head;
        }

        ListNode next = head.next;
        ListNode newNode = reverseN(next, n - 1);
        next.next = head;
        head.next = successor;

        return newNode;
    }
}
