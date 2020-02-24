package com.xiong.LeetCode.BinarySearchTree;

import com.xiong.LeetCode.TreeNode;

import java.util.ArrayList;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/23 16:25
 * @description： 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
 * @modified By：
 * @version: $
 */
public class B9_getMinimumDifference {
    /**
     * @author: xiongcong
     * @Date: 2020/2/23 16:27
     * @Description: 中序遍历得到 一个 递增的有序数组
     * 然后 判断这个数组中 相邻位置的差 最小值
     *
     */
    private ArrayList<Integer> list = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <list.size() - 1; i++) {
            int temp = Math.abs(list.get(i) - list.get(i + 1));
            if (temp < min){
                min = temp;
            }
        }
        return min;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    /**
     *  @author: xiongcong
     *  @Date: 2020/2/23 16:35
     *  @Description: 官方解答
     */
    private int minDiff = Integer.MAX_VALUE;
    private TreeNode preNode = null;

    public int getMinimumDifference_2(TreeNode root) {
        inOrder(root);
        return minDiff;
    }

    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        if (preNode != null) minDiff = Math.min(minDiff, node.val - preNode.val);
        preNode = node;
        inOrder(node.right);
    }
}
