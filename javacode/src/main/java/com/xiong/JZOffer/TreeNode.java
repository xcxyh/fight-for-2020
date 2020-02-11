package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2019/12/7 15:33
 * @description： 二叉树
 * @modified By：
 * @version: $
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        this.val = x;
    }

    TreeNode(int x, TreeNode left, TreeNode right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }

    /**
     * @author: xiongcong
     * @Date: 2020/2/10 15:11
     * @Description: 打印 节点的值
     */
    public void operate(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
    }

    /**
     * @author: xiongcong
     * @Date: 2020/2/10 15:12
     * @Description: 前序遍历  根 -> 左 -> 右
     */
    public void iterateFirstOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        operate(node);
        iterateFirstOrder(node.left);
        iterateFirstOrder(node.right);
    }

    /**
     * @author: xiongcong
     * @Date: 2020/2/10 15:12
     * @Description: 中序遍历  左  根  右
     */
    public void iterateMediumOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        iterateFirstOrder(node.left);
        operate(node);
        iterateFirstOrder(node.right);

    }

    /**
     * @author: xiongcong
     * @Date: 2020/2/10 15:12
     * @Description: 后序遍历  左   右   根
     */
    public void iterateLastOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        iterateFirstOrder(node.left);
        iterateFirstOrder(node.right);
        operate(node);
    }


}
