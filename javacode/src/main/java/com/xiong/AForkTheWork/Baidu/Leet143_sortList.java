package com.xiong.AForkTheWork.Baidu;

import com.xiong.ListNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/1 12:36
 * @description： 148. 排序链表   在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * @modified By：
 * @version: $
 */
public class Leet143_sortList {
    public static void main(String[] args) {

        ListNode head = ListNode.generateListNodeFromArr(new int[]{5, 2, 4, 6, 1});
        System.out.println(new Leet143_sortList().sortList_merge(head));
    }
    // 比数组的归并简单
    // 归并排序 ，，，，原来 面试官的意思是这个 ，卧槽  ，我吐了，
    // 由 合并两个有序链表 ----->  归并排序链表
    public ListNode sortList_merge(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode left = sortList_merge(head);
        ListNode right = sortList_merge(mid);

        return mergeList(left, right);
    }


    // 合并两个有序链表
    public ListNode mergeList(ListNode l1, ListNode l2) {
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

                if (l1.val < l2.val) {
                    head = l1;
                    l1 = l1.next;
                } else {
                    head = l2;
                    l2 = l2.next;
                }
                cur = head;
            } else {
                if (l1.val < l2.val) {
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


    // 快速排序
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        quickSort(head, null);

        return head;
    }

    // [start, end)
    private void quickSort(ListNode start, ListNode end) {

        if (start == end) {
            return;
        }

        int temp = start.val;
        ListNode mid = start;
        ListNode cur = start.next;
        while (cur != end) {

            if (cur.val < temp) {
                mid = mid.next;
                // 如果 他们的值不等的话，交换 mid 的值 和 cur的值
                if (mid.val != cur.val) {
                    int t = mid.val;
                    mid.val = cur.val;
                    cur.val = t;
                }
            }

            cur = cur.next;

        }
        // 交换 值
        start.val = mid.val;
        mid.val = temp;

        quickSort(start, mid);
        quickSort(mid.next, end);

    }
}
