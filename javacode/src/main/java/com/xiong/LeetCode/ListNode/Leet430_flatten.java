package com.xiong.LeetCode.ListNode;

import com.xiong.LeetCode.TreeNode;

import java.util.Stack;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/18 11:29
 * @description： 430. 扁平化多级双向链表  与   114. 二叉树展开为链表 思考方式一模一样
 *   头向左一歪  这就是个二叉树   前序遍历逆遍历
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

    // 这才是正确的思考方式得到的答案
    //   与   114. 二叉树展开为链表 思考方式一模一样
    // 前序 遍历 的逆遍历  右 -> 左 -> 中
    private Node pre = null;
    public Node flatten(Node head) {
        reversePreOrder(head);
        return head;
    }

    private void reversePreOrder(Node head){
        if (head == null){
            return;
        }
        reversePreOrder(head.next);  // 右
        reversePreOrder(head.child); // 左

        head.next = pre;
        if (pre != null){
            pre.prev = head;
        }
        head.child = null;
        pre = head;

    }

    //114. 二叉树展开为链表 答案，与本题完全一致
    TreeNode pre114 = null;
    //原地
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        // 前序遍历的 倒序    右 ——> 左 ——> 中

        flatten(root.right);
        flatten(root.left);
        root.right = pre114;
        root.left = null;
        pre114 = root;
    }



    Stack<Node> stack = new Stack<>();
    public Node flatten_old(Node head) {
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

}
