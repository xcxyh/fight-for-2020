package com.xiong.LeetCode.JianZhiOffer;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/3 16:58
 * @description：  面试题68 - II. 二叉树的最近公共祖先
 * @modified By：
 * @version: $
 */
public class J68_2_lowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null){
            return right;
        }
        if (right == null){
            return left;
        }
        return root;
    }
}
