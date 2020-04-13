package com.xiong.LeetCode.BinaryTree;

import com.xiong.LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/11 15:27
 * @description： 二叉树层次遍历  bfs
 * @modified By：
 * @version: $
 */
public class B0_levelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        //bfs
        if (root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();// 记录当前层的大小
            List<Integer> res = new ArrayList<>();
            while(size-- > 0){
                TreeNode temp = queue.poll();
                if(temp.left != null){
                    queue.offer(temp.left);
                }
                if(temp.right != null){
                    queue.offer(temp.right);
                }
                res.add(temp.val);
            }
            ans.add(res);
        }
        return ans;
    }
}
