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

    public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if (root == null || root == p || root == q){
            return root;
        }

        TreeNode left_com = lowestCommonAncestor_1(root.left, p, q);

        TreeNode right_com = lowestCommonAncestor_1(root.right, p, q);
        //左子树找不到 直接返回右子树的结果
        if (left_com == null){
            return right_com;
        }

        if (right_com == null ){
            return left_com;
        }

        // 两个 都不为null 证明 一个为p  一个为 q 直接返回 root 即为最低公共祖先
        return root;

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //基线条件
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);//去左子树中找这两个节点 的公共祖先
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        /*if (left == null){ // 左为空 就返回 右的结果
            return right;
        }
        if (right == null){ // 右为空 就返回 左的结果
            return left;
        }
        return root;*/ // 两个都不为空  就返回 root
        // 三元运算符表示
        return left == null ? right : right == null ? left : root;

    }
}
