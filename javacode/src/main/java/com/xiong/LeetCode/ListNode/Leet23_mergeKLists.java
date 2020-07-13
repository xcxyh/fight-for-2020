package com.xiong.LeetCode.ListNode;

import com.xiong.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/26 8:37
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet23_mergeKLists {

    //暴力枚举  121 ms
    public ListNode mergeKLists_basic(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode ans = null;

        for (ListNode node : lists) {
            ans = merge2Lists(ans, node);
        }
        return ans;
    }

    //分治合并  有一说一 时间复杂度并没有显著降低
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        int len = lists.length;

        while (len > 1) {
            int i;
            for( i= 0; i < len /2 ; i++){
                //注意到这里将位置2i与2i+1的两个链表合并到位置i上。
                lists[i] = merge2Lists(lists[2*i],lists[2*i + 1]);
            }

            //处理奇数的情况。把最后一个链表放到下次待求解数组的末端，顺便解决向上取整的问题
            //最后一个单独作为 一个合并后的链表
            if((len%2)!=0){
                lists[i]=lists[len-1];
                len++;// 注意 这里长度要加1 ， 即向上取整
            }
            //减半
            len /= 2;
        }

        return lists[0];
    }


    /**
     * @author: xiongcong
     * @Date: 2020/4/26 8:57
     * @Description: 合并两个有序链表
     */
    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = null;
        ListNode cur = null;

        while (l1 != null && l2 != null) {
            if (head == null) {
                if (l1.val <= l2.val) {
                    head = l1;
                    l1 = l1.next;
                } else {
                    head = l2;
                    l2 = l2.next;
                }
                cur = head;
            } else {
                if (l1.val <= l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
        }

        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }

        return head;
    }


    // 图方便  使用优先队列  9 ms
    public ListNode mergeKLists_queue(ListNode[] lists) {
        //优先队列
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (ListNode node : lists) {
            while (node != null) {
                queue.offer(node);
                node = node.next;
            }
        }

        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            node.next = null;
            cur.next = node;
            cur = cur.next;
        }
        return pre.next;
    }


}
