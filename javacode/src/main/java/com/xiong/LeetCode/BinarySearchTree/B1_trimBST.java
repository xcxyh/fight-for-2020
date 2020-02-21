package com.xiong.LeetCode.BinarySearchTree;


import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/21 15:18
 * @description：
 * 给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，
 * 使得所有节点的值在[L, R]中 (R>=L) 。
 * 你可能需要改变树的根节点，
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。
 * @modified By：
 * @version: $
 */
public class B1_trimBST {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null){
            return null;
        }
        //根节点不符合条件
        if (root.val > R){
            //根节点大于R  则 根节点的右子树所有节点都大于R 全部去掉
            //返回 修剪后的 左子树
            return trimBST(root.left, L, R);
        }
        if (root.val < L){
            //返回 修剪后的 右子树
            return trimBST(root.right, L, R);
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
