package com.xiong.LeetCode.BinarySearchTree;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/4/25 14:06
 * @description：   897. 递增顺序搜索树   从尾部开始  右中左 遍历
 * @modified By：
 * @version: $
 */
public class Leet897_increasingBST {

    private TreeNode successor = null;
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);

        return successor;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.right);

        root.right = successor;
        TreeNode left_temp = root.left;
        successor = root;
        successor.left = null;
        inorder(left_temp);

    }
}
