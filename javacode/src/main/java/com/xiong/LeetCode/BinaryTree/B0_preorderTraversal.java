package com.xiong.LeetCode.BinaryTree;

import com.xiong.LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/11 12:31
 * @description： 二叉树前序遍历
 * @modified By：
 * @version: $
 */
public class B0_preorderTraversal {

    private List<Integer> ans = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preNonRecusive(ans,root);
        return ans;
    }
    //非递归
    private void preNonRecusive(List<Integer> ans,TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        //DFS 完成 前序遍历
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            ans.add(cur.val);
            //**** 先右 后左  然后弹栈时 左节点先弹出 ****
            if(cur.right != null){
                stack.push(cur.right);
            }

            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    //递归
    private void preTravesal(TreeNode root){
        if (root == null){
            return;
        }
        ans.add(root.val);
        preTravesal(root.left);
        preTravesal(root.right);
    }
}
