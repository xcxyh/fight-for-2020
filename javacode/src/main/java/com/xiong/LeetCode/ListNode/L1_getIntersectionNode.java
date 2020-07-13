package com.xiong.LeetCode.ListNode;

import com.xiong.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/27 13:34
 * @description：
 * 编写一个程序，找到两个单链表相交的起始节点。
 *  双指针： indexA 从 A链开始  indexB从B链开始
 *  当indexA 走到 尾部时 跳到 B 链头部
 *  当indexB 走到 尾部时 跳到 A 链头部
 *  直到相遇 或 为null
 *  相遇时 indexA 和indexB 走过了相同的距离
 * @modified By：
 * @version: $
 */
public class L1_getIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode indexA = headA;
        ListNode indexB = headB;

        while (indexA != indexB){
            if (indexA != null){
                indexA = indexA.next;
            }else{
                indexA =  headB;
            }

            if (indexB != null){
                indexB = indexB.next;
            }else{
                indexB =  headA;
            }
        }
        return indexA;
    }

}
