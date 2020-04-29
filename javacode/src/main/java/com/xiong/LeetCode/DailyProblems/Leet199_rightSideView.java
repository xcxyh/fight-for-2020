package com.xiong.LeetCode.DailyProblems;

import com.xiong.LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/22 9:01
 * @description： 199. 二叉树的右视图
 * @modified By：
 * @version: $
 */
public class Leet199_rightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        //层次遍历返回每层最后一个元素
        if (root == null){
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();

            while(size-- >0){
                TreeNode node = q.poll();
                if (size == 0){
                    ans.add(node.val);
                }
                if (node.left != null){
                    q.offer(node.left);
                }
                if (node.right != null){
                    q.offer(node.right);
                }
            }
        }
        return ans;

    }

}
