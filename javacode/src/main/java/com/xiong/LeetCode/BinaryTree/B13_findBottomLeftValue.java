package com.xiong.LeetCode.BinaryTree;

import com.xiong.LeetCode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/18 15:13
 * @description： 给定一个二叉树，在树的最后一行找到最左边的值。
 * 注意: 您可以假设树（即给定的根节点）不为 NULL。
 * @modified By：
 * @version: $
 */
public class B13_findBottomLeftValue {

    public int findBottomLeftValue(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // bfs 广度优先遍历
        while (!queue.isEmpty()) {
            root = queue.poll();
            //每次都是右节点先入队 保证 队列中最后一个节点为最左节点
            if (root.right != null) {
                queue.offer(root.right);
            }
            if (root.left != null) {
                queue.offer(root.left);
            }
        }

        return root.val;
    }

}
