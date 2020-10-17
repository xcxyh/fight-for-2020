package com.xiong.LeetCode.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/14 10:27
 * @description： 填充每个节点的下一个右侧节点指针 II (一般二叉树)
 *
 * // 不使用额外空间 的方法
 * @modified By：
 * @version: $
 */
public class Leet117_connect {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Node cur = root;

        while (cur != null){
            Node pre = new Node(-1); //当前层的头部
            Node tail = pre;//当前层的 遍历指针
            // 遍历上一层的节点， 得到当前层的所有节点，连起来
            while (cur != null){
                if(cur.left != null){
                    tail.next = cur.left;
                    tail = tail.next;
                }
                if(cur.right != null){
                    tail.next = cur.right;
                    tail = tail.next;
                }
                cur = cur.next; // 上一层的 遍历指针
            }
            cur = pre.next;// 跳到下一层的第一个节点上
        }

        return root;
    }


    public Node connect2(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            Node pre = null;
            while ( size-- > 0 ) {
                Node node = q.poll();
                if (pre == null) {
                    pre = node;
                }else{
                    pre.next = node;
                    pre = node;
                }

                if ( node.left != null ) {
                    q.offer(node.left);
                }

                if ( node.right != null ) {
                    q.offer(node.right);
                }

            }
        }

        return root;

    }

}
