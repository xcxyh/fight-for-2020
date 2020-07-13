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

    private int global_k ;
    private int ans = 0;
    public int kthLargest(TreeNode root, int k) {
        global_k = k;

        reverseInorder(root);
        return ans;
    }
    // 中序遍历的 反遍历   右 -->  中 --> 左
    private void reverseInorder(TreeNode root){
        if (root == null){
            return;
        }
        reverseInorder(root.right);
        global_k--;
        if (global_k == 0){
            ans = root.val;
            return;
        }
        reverseInorder(root.left);
    }
}
