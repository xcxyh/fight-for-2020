package com.xiong.LeetCode.BinaryTree;


/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/17 15:49
 * @description： 最长同值路径
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。
 * 这条路径可以经过也可以不经过根节点。
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 * @modified By：
 * @version: $
 */
public class B9_longestUnivaluePath {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(5);
        TreeNode r1 = new TreeNode(5);
        TreeNode r2 = new TreeNode(5);
        TreeNode r3 = new TreeNode(1);
        TreeNode r4 = new TreeNode(1);
        TreeNode r5 = new TreeNode(12);
        root1.left = r1;
        root1.right = r2;
        r1.left = r3;
        r1.right = r4;
        r2.right = r5;
        new B9_longestUnivaluePath().longestUnivaluePath(root1);
    }
    private int ret = 0;
    /**
     * @author: xiongcong
     * @Date: 2020/2/17 16:29
     * @Description: 最长同值路径 这题在leetcode上为easy 但是很难
     */
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ret;
    }
    /**
     *  @author: xiongcong
     *  @Date: 2020/2/17 16:47
     *  @Description:
     *  递归函数 dfs 中做了两件事：
     *
     * 1、计算以当前节点为根、且经过当前节点的最长路径（单侧）的边数，该值用来返回给父节点。
     *
     * 2、对每一个节点计算以当前节点为根、且经过当前节点的最长路径（双侧）的边数，所有节点中的最大值即是要求的结果。
     */
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftPath = 0;
        int rightPath = 0;
        if (root.left != null && root.left.val == root.val) {
            leftPath = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            rightPath = right + 1;
        }
        //所有节点中的最大值 将左右相加  为双侧 最长路径
        ret = Math.max(ret, leftPath + rightPath);
        //以当前节点为根节点 的 单侧最长路径
        return Math.max(leftPath, rightPath);
    }
}
