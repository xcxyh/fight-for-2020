package com.xiong.LeetCode.ListNode;

import com.xiong.ListNode;

import java.util.Stack;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/17 19:47
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet445_addTwoNumbers2 {

    //这里使用了栈 也可以 原地翻转链表  不使用额外空间
    public static ListNode addTwoNumbers_stack(ListNode l1, ListNode l2) {

        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        ListNode cur1 = l1;
        while(cur1 != null){
            stack1.push(cur1.val);
            cur1 = cur1.next;
        }

        ListNode cur2 = l2;
        while(cur2 != null){
            stack2.push(cur2.val);
            cur2 = cur2.next;
        }
        ListNode head = new ListNode(1); // 最高位
        ListNode pre = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            int i = 0; int j = 0;
            if(!stack1.isEmpty()){
                i = stack1.pop();
            }
            if(!stack2.isEmpty()){
                j = stack2.pop();
            }

            int temp = i + j + carry;
            carry = temp / 10;
            temp = temp % 10;
            ListNode node = new ListNode(temp);
            //这里使用头插法
            node.next = pre;
            pre = node;

        }
        if (carry != 0){
            head.next = pre;
            pre = head;
        }
        return pre;
    }
}
