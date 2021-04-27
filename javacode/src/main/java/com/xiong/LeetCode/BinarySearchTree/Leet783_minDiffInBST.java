package com.xiong.LeetCode.BinarySearchTree;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/4/13 10:16
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet783_minDiffInBST {

    int ans = Integer.MAX_VALUE;
    int pre = -1;
    public int minDiffInBST(TreeNode root) {
        inorder(root);

        return ans;
    }

    private void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);
        if (pre != -1) {
            ans = Math.min(ans, Math.abs(root.val - pre));
        }
        pre = root.val;
        inorder(root.right);
    }
}
