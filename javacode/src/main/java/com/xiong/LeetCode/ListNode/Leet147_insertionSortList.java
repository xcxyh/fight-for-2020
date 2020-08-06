package com.xiong.LeetCode.ListNode;

import com.xiong.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/1 18:55
 * @description： 147. 对链表进行插入排序
 * @modified By：
 * @version: $
 */
public class Leet147_insertionSortList {

    public static void main(String[] args) {

        ListNode head = ListNode.generateListNodeFromArr(new int[]{-1,5,3,4,0});
        System.out.println(new Leet147_insertionSortList().insertionSortList(head));
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode pcur = new ListNode(Integer.MIN_VALUE);
        pcur.next = head;

        ListNode pre = pcur;
        ListNode cur =head;

        while(cur != null){
            // 如果当前值 小于 他的 pre 的值 就 执行 插入排序操作 否则不执行，
            if (cur.val < pre.val){
                // 删除
                ListNode next = cur.next;
                pre.next = next;

                // 找到插入位置
                ListNode j = pcur.next;
                ListNode prej = null;
                while (j != null && cur.val > j.val){ // 找到 插入位置
                    prej = j;
                    j = j.next;
                }
                // 插入
                cur.next = j;
                if (prej != null){
                    prej.next = cur;
                }else{ // cur 变为了头节点的情况
                    pcur.next = cur;
                }
                // 下一轮
                cur = next;
            }else{
                // 继续 向后寻找
                pre = pre.next;
                cur = cur.next;
            }

        }

        return pcur.next;
    }

}
