package com.xiong.LeetCode.BinarySearchTree;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/15 11:31
 * @description： Insert into a Binary Search Tree
 * @modified By：
 * @version: $
 */
public class Leet701_insertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null){
            return new TreeNode(val);
        }


        if (root.val < val){
            root.right = insertIntoBST(root.right, val);
        }

        if (root.val > val){
            root.left = insertIntoBST(root.left , val);
        }

        return root;
    }
}
