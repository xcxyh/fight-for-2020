package com.xiong.LeetCode.JianZhiOffer;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/28 13:58
 * @description： 面试题55 - II. 平衡二叉树
 * @modified By：
 * @version: $
 */
public class J55_isBalanced {

    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        int left = depth(root.left);
        int right = depth(root.right);

        return Math.abs(right - left) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    //求深度
    private int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftdepth = depth(root.left);
        int rightdepth = depth(root.right);
        return Math.max(leftdepth, rightdepth) + 1;

    }
}
