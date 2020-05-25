package com.xiong.LeetCode.BinaryTree;

import com.xiong.LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/13 9:40
 * @description： 103. 二叉树的锯齿形层次遍历
 * @modified By：
 * @version: $
 */
public class Leet103_zigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int flag = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> list = new LinkedList<>();
            while (size-- > 0) {
                TreeNode t = q.poll();
                if (flag == 0) {
                    list.addLast(t.val); //尾插  LinkedList 的方法
                } else {
                    list.addFirst(t.val); //头插  LinkedList 的方法
                }

                if (t.left != null) {
                    q.offer(t.left);
                }
                if (t.right != null) {
                    q.offer(t.right);
                }

            }
            flag = flag ^ 1;
            ans.add(list);
        }
        return ans;
    }
}
