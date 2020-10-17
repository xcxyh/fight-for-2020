package com.xiong.LeetCode.BinaryTree;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/9/19 10:19
 * @description：  404. 左叶子之和
 * @modified By：
 * @version: $
 */
public class Leet404_sumOfLeftLeaves {


    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        inorder(root);
        return sum;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        inorder(root.right);
    }
}
