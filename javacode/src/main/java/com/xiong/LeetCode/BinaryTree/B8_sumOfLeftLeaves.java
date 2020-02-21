package com.xiong.LeetCode.BinaryTree;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/16 15:22
 * @description： 计算给定二叉树的所有左叶子之和。 ac
 * @modified By：
 * @version: $
 */
public class B8_sumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        int ret = 0;
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            ret = root.left.val;
        }
        return ret + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
