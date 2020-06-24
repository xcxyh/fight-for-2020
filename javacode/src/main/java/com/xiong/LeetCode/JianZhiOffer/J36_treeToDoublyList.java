package com.xiong.LeetCode.JianZhiOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/18 11:52
 * @description：  面试题36. 二叉搜索树与双向链表
 * @modified By：
 * @version: $
 */
public class J36_treeToDoublyList {

    private Node head = null;
    private Node pre = null;
    public Node treeToDoublyList(Node root) {
        if (root == null){
            return root;
        }

        inorder(root);
        //遍历完之后 此时的pre 就为 尾节点了

        //最后将 首尾连接起来就行了
        head.left = pre;

        pre.right = head;

        return head;
    }

    private void inorder(Node node){
        if (node  == null){
            return;
        }

        inorder(node.left);

        if (head == null){
            head = node;
        }
        // right 相当于 next
        //left 相当于 prev

        //1 当前 左指针指向 pre
        node.left = pre;
        //2 pre 不为空 时  pre的 右指针指向 当前
        if (pre != null){
            pre.right = node;// 上一个的右 指向 当前
        }
        //3 将 当前置为 pre
        pre = node;

        inorder(node.right);
    }

    class Node{

        int val;
        Node left;
        Node right;

        Node(int x ) {
            val = x;
        }
    }
}
