package com.xiong.JZOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author ：xiongcong
 * @date ：Created in 2019/12/7 11:24
 * @description： 从尾到头打印链表 从尾到头反过来打印出每个结点的值。
 * @modified By：
 * @version: $
 */
public class J06_PrintListNode {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        System.out.println(printListFromTailToHead_3(listNode));
    }

    /**
     * @author: xiongcong
     * @Date: 2019/12/7 14:51
     * @Description: 递归
     */
    public ArrayList<Integer> printListFromTailToHead_1(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead_1(listNode.next));
            ret.add(listNode.val);

        }
        return ret;
    }

    /**
     * @author: xiongcong
     * @Date: 2019/12/7 14:52
     * @Description: 头插法
     * head -> 1
     * head -> 2 -> 1
     * head -> 3 -> 2 -> 1
     * head -> 4 -> 3 -> 2 -> 1
     */
    public static ArrayList<Integer> printListFromTailToHead_2(ListNode listNode) {

        ListNode head = new ListNode(-1);
        while (listNode != null) {
            //保存指向下一个的指针
            ListNode temp = listNode.next;
            //将当前头节点的指针 给当前节点
            listNode.next = head.next;
            //头节点指向 当前节点
            head.next = listNode;
            //下一个node
            listNode = temp;
        }
        // 构建 ArrayList
        ArrayList<Integer> ret = new ArrayList<>();
        head = head.next;
        while (head != null) {
            ret.add(head.val);
            head = head.next;
        }
        return ret;
    }

    /**
     * @author: xiongcong
     * @Date: 2019/12/7 15:21
     * @Description: 使用堆栈
     */
    public static ArrayList<Integer> printListFromTailToHead_3(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        // 构建 ArrayList
        ArrayList<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty()) {
            ret.add(stack.pop());
        }
        return ret;
    }
}
