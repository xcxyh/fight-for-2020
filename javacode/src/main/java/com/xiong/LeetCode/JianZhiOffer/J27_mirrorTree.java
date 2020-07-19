package com.xiong.LeetCode.JianZhiOffer;

import com.xiong.LeetCode.TreeNode;

import java.util.ArrayDeque;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/16 16:58
 * @description：  剑指 Offer 27. 二叉树的镜像
 * @modified By：
 * @version: $
 */
public class J27_mirrorTree {

    //非递归
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return null;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();


        stack.push(root);

        while(!stack.isEmpty()){

            TreeNode node = stack.pop();

            if (node.left != null){
                stack.push(node.left);
            }

            if (node.right != null){
                stack.push(node.right);
            }

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

        }
        return root;
    }

    //递归
    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;

        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);

        return root;
    }
}
