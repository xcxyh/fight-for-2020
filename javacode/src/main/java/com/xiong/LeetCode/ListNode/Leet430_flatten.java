package com.xiong.LeetCode.ListNode;

import java.util.Stack;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/18 11:29
 * @description： 430. 扁平化多级双向链表
 *   头向左一歪  这就是个二叉树   前序遍历
 * @modified By：
 * @version: $
 */
public class Leet430_flatten {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }


    Stack<Node> stack = new Stack<>();
    public Node flatten(Node head) {
        if (head == null){
            return head;
        }
        preorder(head);
        Node pre = null;// 头插法
        while(!stack.isEmpty()){
            Node node = stack.pop();
            node.next = pre;
            if(pre != null){
                pre.prev = node;
            }
            node.child = null;
            pre = node;
        }
        return pre;
    }
    //前序遍历
    // next 相当于right  child 相当于 left
    private void preorder(Node head){
        if (head == null){
            return;
        }

        stack.push(head);
        preorder(head.child);
        preorder(head.next);
    }


    /**
     *  @author: xiongcong
     *  @Date: 2020/4/18 11:31
     *  @Description: 大佬的答案，还可以使用dfs  深度优先遍历
     */
    private Node prev = null;
    public Node flatten_dalao(Node head) {
        dfs(head);
        return head;
    }
    // 相当于 一个前序遍历
    private void dfs(Node head) {
        if (head == null) return;
        //中
        Node next = head.next;
        if (prev != null) {//目的是为了分支处（child递归进去）和child分支最后（child递归弹出）建立链接
            prev.next = head;
            head.prev = prev;
        }
        prev = head;

        dfs(head.child); //左
        head.child = null; //递归遍历过child分支了，反弹后，prev为child分支最后一个，head为分支出口，child至空去掉分支
        dfs(next); //右
    }
}
