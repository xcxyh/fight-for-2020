package com.xiong.LeetCode.BinarySearchTree;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/14 12:59
 * @description：   验证二叉搜索树
 * @modified By：
 * @version: $
 */
public class Leet98_isValidBST {
    // 利用中序遍历
    private Integer min = null;
    private boolean ans = true;
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        //中序遍历
        inorder(root);
        return ans;
    }
    private void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        int val = root.val;
        // 中序遍历中判断 是否一直递增
        if(min == null){
            min = val;
        }else if (val > min){
            min = val;
        }else{
            ans = false;
        }
        inorder(root.right);
    }
}
