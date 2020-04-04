package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/3 20:28
 * @description：
 * @modified By：
 * @version: $
 */
public class J36_TreeToDList {

    private TreeNode pre = null;
    private TreeNode head = null;

    public TreeNode Convert(TreeNode root) {
        inOrder(root);
        return head;
    }
        //中序遍历
    private void inOrder(TreeNode node) {
        if (node == null)
            return;
        inOrder(node.left);
        node.left = pre; // 当前的左 指向上一个
        if (pre != null)
            pre.right = node;// 上一个的右 指向 当前
        pre = node;
        if (head == null)
            head = node;
        inOrder(node.right);
    }
}
