package com.xiong.LeetCode.ListNode;

import com.xiong.JZOffer.ListNode;

import java.util.Stack;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/29 16:53
 * @description： 2. 两数相加  中等
 * @modified By：
 * @version: $
 */
public class L11_addTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3);

        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        l5.next = l6;
        l6.next = l7;
        ListNode re = addTwoNumbers_stack(l1, l5);
        System.out.println(re.toString());
    }
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


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 将两个链表 补成长度一致
        ListNode ll1 = l1;
        int len1 = 1;
        while (ll1.next != null) {
            ll1 = ll1.next;
            len1++;
        }
        ListNode ll2 = l2;
        int len2 = 1;
        while (ll2.next != null) {
            ll2 = ll2.next;
            len2++;
        }
        int cont = Math.abs(len2 - len1);
        if (len1 > len2) {
            while (cont-- > 0) {
                ll2.next = new ListNode(0);
                ll2 = ll2.next;
            }
        }
        cont = Math.abs(len2 - len1);
        if (len1 < len2) {
            while (cont-- > 0) {
                ll1.next = new ListNode(0);
                ll1 = ll1.next;
            }
        }
        // 计算
        ListNode head1 = l1;
        ListNode pre = l1;
        int carry = 0; //进位
        while (l1 != null && l2 != null) {
            int v = l1.val + l2.val + carry;
            l1.val = v % 10;
            carry = v / 10;
            pre = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            pre.next = new ListNode(1);
        }
        return head1;
    }

}
