package com.xiong.LeetCode.BinaryTree;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/16 15:10
 * @description：
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 * @modified By：
 * @version: $
 */
public class B7_minDepth {

    public int minDepth(TreeNode root) {
         if (root == null){
             return 0;
         }
         int leftDepth = minDepth(root.left);
         int rightDepth = minDepth(root.right);
         //到叶子节点为止 这里是或
        if (leftDepth == 0 || rightDepth == 0) {
            return leftDepth + rightDepth + 1;
        }
         return Math.min(leftDepth,rightDepth) + 1;

    }
}
