package com.xiong.LeetCode.BinarySearchTree;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/21 16:22
 * @description：
 * 给定一个二叉搜索树（Binary Search Tree），
 * 把它转换成为累加树（Greater Tree)，
 * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * @modified By：
 * @version: $
 */
public class B3_convertBST {

    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        inorder(root);
        return root;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        // 右中左
        inorder(root.right);
        int val = root.val;
        root.val = val + sum;
        sum += val;
        inorder(root.left);
    }





    //反方向的中序遍历 然后累加加
    public TreeNode convertBST2(TreeNode root){
        inorderbst(root);
        return root;

    }
    private int val = 0;
    private void inorderbst(TreeNode root){
        if (root == null){
            return ;
        }
        //先右后左
        inorderbst(root.right);
        val += root.val;
        root.val = val;
        inorderbst(root.left);
    }

}
