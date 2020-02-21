package com.xiong.LeetCode.BinaryTree;

import com.xiong.LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/18 14:54
 * @description： 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 * @modified By：
 * @version: $
 */
public class B12_averageOfLevels {

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        //使用bfs 利用队列 广度优先遍历
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> ret = new ArrayList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            double sum = 0.0;
            for (int i = 0; i < count; i++) {
                TreeNode temp = queue.poll();
                if (temp != null) {
                    sum += temp.val;
                    if (temp.left != null) {
                        queue.offer(temp.left);
                    }
                    if (temp.right != null) {
                        queue.offer(temp.right);
                    }
                }
            }
            ret.add(sum / count);
        }
        return ret;
    }
}
