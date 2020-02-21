package com.xiong.LeetCode.BinaryTree;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/17 16:53
 * @description： 二叉树间隔遍历
 *
 * 解法：
 * 分情况遍历：
 * 1 路径中包含根节点
 * 2 不包含根节点 （以根节点为间隔）
 * @modified By：
 * @version: $
 */
public class B10_rob {

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //遍历路径中包括根节点
        int val1 = root.val;
        if (root.left != null) {
            val1 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val1 += rob(root.right.left) + rob(root.right.right);
        }
        //遍历路径中不包括根节点
        int val2 = rob(root.left) + rob(root.right);

        return Math.max(val1, val2);
    }
}
