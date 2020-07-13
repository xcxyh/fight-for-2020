package com.xiong.LeetCode.ListNode;

import com.xiong.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/25 17:06
 * @description： 82. 删除排序链表中的重复元素 II, 三指针法  ， pcur + left + right
 * @modified By：
 * @version: $
 */
public class Leet82_deleteDuplicates {


    public static void main(String[] args) {
        ListNode head = ListNode.generateListNodeFromArr(new int[] {1,1,2,2,3,4});

        System.out.println(deleteDuplicates(head));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pcur = new ListNode(-1); // 哨兵指针
        pcur.next = head;
        head = pcur;// 保存头节点
        while(pcur.next != null){
            ListNode left = pcur.next; // 直接让 左右指针从 哨兵指针的后面开始
            ListNode right = pcur.next;
            // 当  right 的下一个 的值 与 left 值相同时
            while(right.next != null && left.val == right.next.val){
                right = right.next;
            }

            if (left == right){ // 证明 当前元素不重复 ，哨兵指针向后移动
                pcur = pcur.next;
            } else{
                pcur.next = right.next;
            }
        }
        return head.next;
    }


}
