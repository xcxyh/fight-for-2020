package com.xiong.LeetCode.BinaryTree;

import com.xiong.LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/9/6 11:53
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet107_levelOrderBottom {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (root== null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (! q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            while(size-- > 0){
                TreeNode t = q.poll();


                list.add(t.val);

                if (t.left != null) {
                    q.offer(t.left);
                }

                if (t.right != null) {
                    q.offer(t.right);
                }

            }

            ans.addFirst(list);

        }

        return ans;
    }
}
