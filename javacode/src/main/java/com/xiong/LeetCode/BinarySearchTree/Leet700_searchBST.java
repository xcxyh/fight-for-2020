package com.xiong.LeetCode.BinarySearchTree;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/15 11:31
 * @description： Search in a Binary Search Tree
 * @modified By：
 * @version: $
 */
public class Leet700_searchBST {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null ){
            return null;
        }
        if (root.val > val){
            return searchBST(root.left, val);
        }else if (root.val < val){
            return searchBST(root.right, val);
        }else{
            return root;
        }


    }
}
