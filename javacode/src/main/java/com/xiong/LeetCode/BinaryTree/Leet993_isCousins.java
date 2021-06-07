package com.xiong.LeetCode.BinaryTree;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/5/17 11:03
 * @description： 993. 二叉树的堂兄弟节点
 * @modified By：
 * @version: $
 */
public class Leet993_isCousins {

    private int depth = 0;
    private int d1 = 0;
    private int d2 = 0;
    private TreeNode f1 = null;
    private TreeNode f2 = null;
    public boolean isCousins(TreeNode root, int x, int y) {

        preorder(root, x, y);
        return d1 == d2 && f1 != f2;
    }

    private void preorder(TreeNode root, int x, int y) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            if (root.left.val == x) {
                f1 = root;
            }else if (root.left.val == y){
                f2 = root;
            }
        }

        if (root.right != null) {
            if (root.right.val == x) {
                f1 = root;
            }else if (root.right.val == y){
                f2 = root;
            }
        }

        if (root.val == x) {
            d1 = depth;
        }else if (root.val == y) {
            d2 = depth;
        }
        depth += 1;
        preorder(root.left, x, y);
        preorder(root.right, x, y);
        depth -= 1;

    }
}
