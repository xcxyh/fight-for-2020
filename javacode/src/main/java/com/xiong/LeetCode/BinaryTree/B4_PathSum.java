package com.xiong.LeetCode.BinaryTree;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/16 14:00
 * @description： J34_FindPath 的  进阶版本
 * <p>
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * <p>
 * 找出路径和等于给定数值的路径总数。
 * <p>
 * 路径不需要从根节点开始，也不需要在叶子节点结束，
 * 但是路径方向必须是向下的（只能从父节点到子节点）。
 * @modified By：
 * @version: $
 */
public class B4_PathSum {
    //递归中全局变量
    private int result = 0;

    private int pathSum(TreeNode root, int sum) {
        if (root == null){
            return 0;
        }
        backtrack(root, sum);
        //以左节点为起点开始
        pathSum(root.left, sum);
        //以右节点为起点开始
        pathSum(root.right, sum);
        return result;
    }
    /**
     *  @author: xiongcong
     *  @Date: 2020/2/16 14:28
     *  @Description: 求解从根节点开始的 所有路径
     */
    private void backtrack(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum = sum - root.val;

        if (sum == 0) {
            result++;
        }
        if (root.left != null) {
            backtrack(root.left, sum);
        }
        if (root.right != null) {
            backtrack(root.right, sum);
        }
    }
}
