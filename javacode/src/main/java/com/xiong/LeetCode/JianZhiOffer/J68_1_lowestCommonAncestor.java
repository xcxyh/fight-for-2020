package com.xiong.LeetCode.JianZhiOffer;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/3 16:59
 * @description： 面试题68 - I. 二叉搜索树的最近公共祖先
 * @modified By：
 * @version: $
 */
public class J68_1_lowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return root;
        }

        if (p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right, p, q);
        }

        if (p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }

        return root;
    }
}
