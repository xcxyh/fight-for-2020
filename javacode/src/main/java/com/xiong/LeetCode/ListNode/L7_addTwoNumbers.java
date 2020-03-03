package com.xiong.LeetCode.ListNode;

import com.xiong.JZOffer.ListNode;

import java.util.Stack;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/28 16:08
 * @description： 给定两个非空链表来代表两个非负整数。
 * 数字最高位位于链表开始位置。
 * 它们的每个节点只存储单个数字。
 * 将这两数相加会返回一个新的链表。
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 * @modified By：
 * @version: $
 */
public class L7_addTwoNumbers {


    public static void main(String[] args) {
        ListNode l1= new ListNode(7);
        ListNode l11= new ListNode(2);
        ListNode l12= new ListNode(4);
        ListNode l13= new ListNode(3);
        l1.next=l11;
        l11.next= l12;
        l12.next = l13;
        ListNode l2 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        ListNode l22 = new ListNode(4);
        l2.next = l21;
        l21.next = l22;

        new L7_addTwoNumbers().addTwoNumbers(l1,l2);
    }
    /**
     *  @author: xiongcong
     *  @Date: 2020/2/28 16:55
     *  @Description: 官方解答 使用两个栈
     *  题目要求：不能修改原始链表。
     */
    public ListNode addTwoNumbers_LeetCode(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = buildStack(l1);
        Stack<Integer> l2Stack = buildStack(l2);
        ListNode head = new ListNode(-1);
        int carry = 0;
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || carry != 0) {
            int x = l1Stack.isEmpty() ? 0 : l1Stack.pop();
            int y = l2Stack.isEmpty() ? 0 : l2Stack.pop();
            int sum = x + y + carry;
            ListNode node = new ListNode(sum % 10);
            //头插法
            node.next = head.next;
            head.next = node;
            carry = sum / 10;
        }
        return head.next;
    }

    private Stack<Integer> buildStack(ListNode l) {
        Stack<Integer> stack = new Stack<>();
        while (l != null) {
            stack.push(l.val);
            l = l.next;
        }
        return stack;
    }


    /**
     *  @author: xiongcong
     *  @Date: 2020/2/28 16:52
     *  @Description: 先使两个链表等长 然后使用递归求解
     *  执行用时 :2 ms, 在所有 Java 提交中击败了100.00%的用户
     *  内存消耗 :40.8 MB, 在所有 Java 提交中击败了86.48%的用户
     */
    private int carry = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        //使两个链表等长
        int l1_len = 0;
        int l2_len = 0;
        ListNode index1 = l1;
        ListNode index2 = l2;

        while (index1 != null) {
            l1_len++;
            index1 = index1.next;

        }
        while (index2 != null) {
            l2_len++;
            index2 = index2.next;
        }
        int temp = Math.abs(l1_len - l2_len);
        if (l1_len > l2_len) {
            for (int i = 0; i < temp; i++) {
                ListNode prehead = new ListNode(0);
                prehead.next = l2;
                l2 = prehead;
            }
        } else if (l1_len < l2_len) {
            for (int i = 0; i < temp; i++) {
                ListNode prehead = new ListNode(0);
                prehead.next = l1;
                l1 = prehead;
            }
        }

        addTwoNum(l1, l2);
        // 满足 类似情况   5 + 5 = 10  此时 最高位为1
        if (carry != 0){
            ListNode prehead = new ListNode(1);
            prehead.next =l1;
            l1 =prehead;
        }
        return l1;

    }
    /**
     *  @author: xiongcong
     *  @Date: 2020/2/28 16:50
     *  @Description: 该函数完成 对两个等长的链表相加
     */
    private void addTwoNum(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return;
        }
        if (l1.next != null && l2.next != null) {

            addTwoNum(l1.next, l2.next);
        }
        int sum = l1.val + l2.val + carry;

        if (sum >= 10) {
            carry = 1;
            l1.val = sum % 10;
        } else {
            carry = 0;
            l1.val = sum;
        }
    }
}
