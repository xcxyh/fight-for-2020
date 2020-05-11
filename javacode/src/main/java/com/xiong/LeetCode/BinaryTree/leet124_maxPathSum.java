package com.xiong.LeetCode.BinaryTree;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/8 11:24
 * @description：124. 二叉树中的最大路径和
 * @modified By：
 * @version: $
 */
public class leet124_maxPathSum {

    private int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null){
            return ans;
        }
        max_gain(root);
        return ans;
    }
    // 该函数完成 求解 从根节点开始 的最大 路径和  必须包含根节点
    private int max_gain(TreeNode root){
        if (root == null){
            return 0;
        }
        int val = root.val;
        // 如果 左 的为负  就不选 即 置为 0
        int left_max = Math.max(max_gain(root.left), 0);
        // 如果 右 的为负  就不选 即 置为 0
        int right_max = Math.max(max_gain(root.right), 0);

        int newSum = Math.max(left_max, right_max) + val;

        int new_path =  val + left_max + right_max;

        ans = Math.max(ans, new_path);

        return newSum;
    }

}
