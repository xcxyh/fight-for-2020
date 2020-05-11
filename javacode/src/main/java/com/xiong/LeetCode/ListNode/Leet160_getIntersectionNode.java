package com.xiong.LeetCode.ListNode;

import com.xiong.JZOffer.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/15 18:44
 * @description： 160. 相交链表
 * @modified By：
 * @version: $
 */
public class Leet160_getIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }

        int size = 0; // 记录 A+B 的长度
        ListNode  cur1 = headA;
        ListNode cur2 = headB;
        while(cur1!= null){
            cur1 = cur1.next;
            size++;
        }
        while(cur2!= null){
            cur2 = cur2.next;
            size++;
        }

        //a b 两个指针
        // 当 a 走到A链尾部 就跳到 B头部
        // 当 b 走到B链尾部 就跳到 A头部
        // a b 相遇则 返回结果
        ListNode a = headA;
        ListNode b = headB;
        while (size-- > 0){
            if (a == null){
                a = headB;
            }
            if (b == null){
                b = headA;
            }
            if (a == b){ // 不要比较值
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;
    }
}
