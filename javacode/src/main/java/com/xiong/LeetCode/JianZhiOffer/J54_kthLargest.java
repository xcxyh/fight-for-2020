package com.xiong.LeetCode.JianZhiOffer;

import com.xiong.LeetCode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/28 12:40
 * @description： 面试题54. 二叉搜索树的第k大节点
 * @modified By：
 * @version: $
 */
public class J54_kthLargest {

    private Queue<Integer> queue;
    private int len = 0;
    public int kthLargest(TreeNode root, int k) {
        if (root == null){
            return 0;
        }
        queue = new LinkedList<>();
        len = k;
        inorder(root);
        return queue.peek();
    }
    private void inorder(TreeNode root){
        if (root == null){
            return;
        }
        inorder(root.left);
        if (queue.size() < len){
            queue.offer(root.val);
        }else{
            queue.poll();
            queue.offer(root.val);
        }
        inorder(root.right);
    }
}
