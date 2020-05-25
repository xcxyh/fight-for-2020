package com.xiong.LeetCode.BinarySearchTree;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/15 12:21
 * @description：    Delete Node in a BST
 * @modified By：
 * @version: $
 */
public class Leet450_deleteNode {


    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null){
            return null;
        }

        if (root.val == key){
            //1
            if (root.left == null && root.right == null){
                return null;
            }
            //2
            if (root.left == null || root.right == null){
                return root.left != null ? root.left : root.right;
            }
            //3
            TreeNode min = getRightMin(root.right);
            root.val = min.val;
            root.right = deleteNode(root.right, min.val);
        }

        if (root.val > key){
            root.left = deleteNode(root.left, key);
        }

        if (root.val < key){
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    private TreeNode getRightMin(TreeNode root){

        while(root.left != null){
            root = root.left;
        }
        return root;
    }

}
