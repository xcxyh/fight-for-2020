package com.xiong.LeetCode.BinaryTree;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/9/22 10:17
 * @description： 968. 监控二叉树
 * @modified By：
 * @version: $
 */
public class Leet968_minCameraCover {

    private int ans = 0;
    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 0) {
            ans++;
        }

        return ans;
    }
    // 返回状态值  0  1  2  代表 未被监控， 被监控， 自身有监控
    private int dfs(TreeNode root) {
        if (root == null) {
            return 1;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        if (left == 0 || right == 0) {
            ans++;
            return 2;
        }
        // 子节点上有监控， 则本身被监控
        if (left + right >= 3) {
            return 1;
        }

        // 左右已经被监控了，该节点不需要装监控，且为初始状态
        if (left == 1 && right == 1) {
            return 0;
        }

        return -1;

    }
}
