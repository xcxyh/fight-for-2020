package com.xiong.LeetCode.BinaryTree;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/15 11:56
 * @description： 合并两个二叉树
 * 你需要将他们合并为一个新的二叉树。
 * 合并的规则是如果两个节点重叠，
 * 那么将他们的值相加作为节点合并后的新值，
 * 否则不为 NULL 的节点将直接作为新二叉树的节点。
 * @modified By：
 * @version: $
 */
public class B2_MergeTrees {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode r1 = new TreeNode(3);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(5);
        root1.left = r1;
        root1.right = r2;
        r1.left = r3;
        TreeNode root2 = new TreeNode(2);
        TreeNode r4 = new TreeNode(1);
        TreeNode r5 = new TreeNode(3);
        TreeNode r6 = new TreeNode(4);
        TreeNode r7 = new TreeNode(7);
        root2.left = r4;
        root2.right = r5;
        r4.right = r6;
        r5.right = r7;
       TreeNode ret = mergeTrees(root1, root2);
        System.out.println(ret);
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
