package com.xiong.LeetCode.BinarySearchTree;

import com.xiong.JZOffer.ListNode;
import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/22 15:49
 * @description： 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * @modified By：
 * @version: $
 */
public class B7_sortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        //与数组不同，链表的长度未知，先快慢指针遍历链表 找到链表的中间节点
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.data);
        }
        TreeNode root;
        ListNode cur = head;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            cur = cur.next;
            fast = fast.next.next;
        }
        //主链 从中断开  此时 slow 为中间节点
        cur.next = null;
        root = new TreeNode(slow.data);
        root.left = sortedListToBST(head); //断开后 为左半部分
        root.right = sortedListToBST(slow.next); //从slow开始为 右
        return root;
    }

    /**
     *  @author: xiongcong
     *  @Date: 2020/2/22 16:24
     *  @Description: 官方解答
     */
    public TreeNode sortedListToBST_2(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.data);
        ListNode preMid = preMid(head);
        ListNode mid = preMid.next;
        preMid.next = null;  // 断开链表
        TreeNode t = new TreeNode(mid.data);
        t.left = sortedListToBST(head);
        t.right = sortedListToBST(mid.next);
        return t;
    }

    private ListNode preMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        ListNode pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;
    }


}
