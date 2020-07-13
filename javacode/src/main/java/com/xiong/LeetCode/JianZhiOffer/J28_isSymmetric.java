package com.xiong.LeetCode.JianZhiOffer;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/29 12:14
 * @description： 剑指 Offer 28. 对称的二叉树
 * @modified By：
 * @version: $
 */
public class J28_isSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymm(root.left, root.right);
    }

    private boolean isSymm(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        return left.val == right.val
                && isSymm(left.left, right.right)
                && isSymm(left.right, right.left);
    }
}
