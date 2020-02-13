package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2019/12/7 15:32
 * @description： 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回
 * 二叉树中没有重复元素
 * 思路：
 * 前序遍历的第一个值为根节点的值，
 * 使用这个值将中序遍历结果分成两部分，左部分为树的左子树中序遍历结果，
 * 右部分为树的右子树中序遍历的结果。然后分别对左右子树递归地求解。
 * @modified By：
 * @version: $
 */
public class J07_ReConstructBTree {
    public static void main(String[] args) {
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};
        TreeNode treeNode =  reConstructBinaryTree( pre, in);
        System.out.println(treeNode);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    /**
     * @author: xiongcong
     * @Date: 2019/12/7 15:57
     * @Description: 重载后的 递归方法
     */
    public static TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        //极限条件
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        //找到根节点
        TreeNode root = new TreeNode(pre[preStart]);
        //在中序遍历中找到根节点，记录下index
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[preStart]) {
                //参数依次为，前序遍历，左子树在前序遍历数组中的起点index 和终点index。中序遍历，左子树在中序遍历数组中的起点index 和终点index。
                root.left = reConstructBinaryTree(pre, preStart + 1, preStart + i - inStart, in, inStart, i - 1);
                root.right = reConstructBinaryTree(pre, preStart + i - inStart + 1, preEnd, in, i + 1, inEnd);
                break;
            }
        }
        return root;
    }
}
