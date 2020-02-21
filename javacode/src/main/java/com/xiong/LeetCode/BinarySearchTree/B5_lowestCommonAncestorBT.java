package com.xiong.LeetCode.BinarySearchTree;

import com.xiong.LeetCode.TreeNode;


/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/21 16:59
 * @description： 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * @modified By：
 * @version: $
 */
public class B5_lowestCommonAncestorBT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //基线条件
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left_ca = lowestCommonAncestor(root.left, p, q);//去左子树中找这两个节点 的公共祖先
        TreeNode right_ca = lowestCommonAncestor(root.right, p, q);
        //p和q均不在树中
        if (left_ca == null && right_ca == null) {
            return null;
        }
        // 一个为空 一个不为空 则 公共祖先为不为空那个
        if (right_ca != null && left_ca == null) {
            return right_ca;
        }
        if (left_ca != null && right_ca == null) {
            return left_ca;
        }
        //两个都不为空 证明 公共祖先为根节点
        return root;

    }
}
