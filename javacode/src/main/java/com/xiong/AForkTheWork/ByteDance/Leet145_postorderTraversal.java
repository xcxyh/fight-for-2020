package com.xiong.AForkTheWork.ByteDance;

import com.xiong.LeetCode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/8 19:48
 * @description： 145. 二叉树的后序遍历  一面
 * @modified By：
 * @version: $
 */
public class Leet145_postorderTraversal {

        //利用 两个栈  可以 不需要 翻转 最后的list
        private List<Integer> postOrder(TreeNode root){
            if (root == null){
                return new ArrayList<>();
            }

            ArrayDeque<TreeNode> stack = new ArrayDeque<>();

            ArrayDeque<Integer> data = new ArrayDeque<>();

            stack.push(root);

            while(!stack.isEmpty()){
                TreeNode temp = stack.pop();

                data.push(temp.val);

                if (temp.left != null){
                    stack.push(temp.left);
                }

                if (temp.right != null){
                    stack.push(temp.right);
                }
            }
            List<Integer> ans = new ArrayList<>();

            while(!data.isEmpty()){
                ans.add(data.pop());
            }

            return ans;
        }

}
