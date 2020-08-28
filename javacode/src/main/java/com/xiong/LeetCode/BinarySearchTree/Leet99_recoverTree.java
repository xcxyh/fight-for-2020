package com.xiong.LeetCode.BinarySearchTree;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/8 9:29
 * @description：  99 恢复二叉搜索树
 * @modified By：
 * @version: $
 */
public class Leet99_recoverTree {

    private TreeNode pre = null;
    private TreeNode x = null;
    private TreeNode y = null;

    // 中序遍历找到这两个需要进行交换的数，最后进行值的交换。
    public void recoverTree(TreeNode root) {
        inorder(root);

        if (x != null && y != null){
            int t = x.val;
            x.val = y.val;
            y.val = t;
        }
    }

    private void inorder(TreeNode root){
        if (root == null){
            return;
        }

        inorder(root.left);
        if (pre != null && pre.val > root.val){
            if (x == null){
                x = pre;
            }
            y = root;
        }
        pre = root;
        inorder(root.right);
    }
}
