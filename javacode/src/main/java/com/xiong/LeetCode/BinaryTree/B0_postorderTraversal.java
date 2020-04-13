package com.xiong.LeetCode.BinaryTree;

import com.xiong.LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/11 14:53
 * @description： 二叉树后序遍历  注意非递归实现
 * @modified By：
 * @version: $
 */
public class B0_postorderTraversal {

    private List<Integer> ans = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postNonRecursive(root);
        return ans;
    }

    //非递归 后序：左 -> 右 -> 中 ，直接求解不好求，换一种思考方式，
    // 不妨先找出 中 -> 右 -> 左 的遍历 然后 翻转list
    //而找到 中 -> 右 -> 左 可以 利用 前序遍历（中 -> 左 -> 右）的非递归代码
    // 只不过将左右的压栈顺序反过来即可
    //翻转list 不好实现的话 可以 再使用一个栈 来保存 中 -> 右 -> 左 的遍历结果
    //然后 依次弹出到 list中去
    private void postNonRecursive(TreeNode root){
        if (root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> data = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            data.push(temp.val);
            //与前序遍历不同
            //**** 先入栈 left  这样 left 后弹出 ****
            if(temp.left != null){
                stack.push(temp.left);
            }

            if(temp.right != null){
                stack.push(temp.right);
            }
        }
        //翻转
        while(!data.isEmpty()){
            ans.add(data.pop());
        }
    }

    //递归
    private void postRecursive(TreeNode root){
        if(root == null){
            return;
        }
        postRecursive(root.left);
        postRecursive(root.right);
        ans.add(root.val);
    }
}
