package com.xiong.LeetCode.BinaryTree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2019/12/7 15:33
 * @description： 二叉树
 * @modified By：
 * @version: $
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        this.val = x;
    }

    TreeNode(int x, TreeNode left, TreeNode right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }

    /**
     * @author: xiongcong
     * @Date: 2020/2/10 15:11
     * @Description: 打印 节点的值
     */
    public void operate(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val +" ");
    }

    /**
     * @author: xiongcong
     * @Date: 2020/2/10 15:12
     * @Description: 前序遍历  根 -> 左 -> 右
     */
    public void iterateFirstOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        operate(node);
        iterateFirstOrder(node.left);
        iterateFirstOrder(node.right);
    }

    /**
     * @author: xiongcong
     * @Date: 2020/2/10 15:12
     * @Description: 中序遍历  左  根  右
     */
    public void iterateMediumOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        iterateMediumOrder(node.left);
        operate(node);
        iterateMediumOrder(node.right);

    }

    /**
     * @author: xiongcong
     * @Date: 2020/2/10 15:12
     * @Description: 后序遍历  左   右   根
     */
    public void iterateLastOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        iterateLastOrder(node.left);
        iterateLastOrder(node.right);
        operate(node);
    }

    public static void main(String[] args) {

        /*
          3
         / \
        9   20
           /  \
          15   7
        */
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
       new TreeNode(1).iterateMediumOrder(root);
    }
    /**
     *  @author: xiongcong
     *  @Date: 2020/2/18 14:41
     *  @Description: bfs层次遍历 二叉树
     *
     */
    public ArrayList<Integer> bfs(TreeNode root){
        if (root == null){
            return new ArrayList<>();
        }
        //利用队列
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();

        queue.offer(root);
        while ( !queue.isEmpty()){

            int count = queue.size();

            for (int i = 0; i <count ; i++) {
                TreeNode temp = queue.poll();
                if (temp != null){
                    ret.add(temp.val);
                    if (temp.left != null){
                        queue.offer(temp.left);
                    }
                    if(temp.right != null){
                        queue.offer(temp.right);
                    }
                }
            }
        }
        return ret;
    }
}
