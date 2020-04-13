package com.xiong.LeetCode.BinaryTree;

import com.xiong.LeetCode.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/11 14:19
 * @description： 中序遍历二叉树
 * @modified By：
 * @version: $
 */
public class B0_inorderTraversal {

    private List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inNonRecusive(root);
        return ans;
    }

    //非递归
    private void inNonRecusive(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {

            //左
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //中
            TreeNode temp = stack.pop();
            ans.add(temp.val);
            //右
            cur = temp.right;

        }
    }
    //递归
    private void inTravesal(TreeNode root) {
        if (root == null) {
            return;
        }
        inTravesal(root.left);
        ans.add(root.val);
        inTravesal(root.right);
    }
}
