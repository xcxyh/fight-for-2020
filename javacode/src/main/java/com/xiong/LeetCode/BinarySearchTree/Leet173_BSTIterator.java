package com.xiong.LeetCode.BinarySearchTree;

import com.xiong.LeetCode.TreeNode;

import java.util.Stack;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/14 11:14
 * @description：  二叉搜索树迭代器  非递归 中序遍历 拆分一下
 * @modified By：
 * @version: $
 */
public class Leet173_BSTIterator {


    Stack<TreeNode> stack = new Stack<>();
    public Leet173_BSTIterator(TreeNode root) {
        leftFirstInorder(root);
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode temp = stack.pop();

        if (temp.right != null){
            leftFirstInorder(temp.right);
        }

        return temp.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void leftFirstInorder(TreeNode root){

        while (root != null){
            stack.push(root);
            root = root.left;
        }

    }
}
