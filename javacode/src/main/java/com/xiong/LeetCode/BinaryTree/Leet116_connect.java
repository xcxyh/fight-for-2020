package com.xiong.LeetCode.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/14 10:18
 * @description： 填充每个节点的下一个右侧节点指针 (满二叉树)
 * @modified By：
 * @version: $
 */
public class Leet116_connect {

    public Node connect(Node root){
        if (root == null){
            return root;
        }

        //层次遍历
        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                Node node = q.poll();
                if(size > 0){ //隔断 每层最后一个node 不做处理  默认指向null
                    node.next = q.peek();
                }

                if(node.left != null){
                    q.offer(node.left);
                }

                if(node.right != null){
                    q.offer(node.right);
                }

            }
        }
        return root;
    }
}


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
