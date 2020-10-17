package com.xiong.LeetCode.BinaryTree;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/9/22 10:39
 * @description： 979. 在二叉树中分配硬币
 * @modified By：
 * @version: $
 */
public class Leet979_distributeCoins {

    private int ans = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);

        ans += Math.abs(left);

        ans += Math.abs(right);

        return root.val + left + right - 1;
    }
}
