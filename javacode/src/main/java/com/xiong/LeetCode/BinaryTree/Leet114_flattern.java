package com.xiong.LeetCode.BinaryTree;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/11 10:31
 * @description：  114. 二叉树展开为链表
 * @modified By：
 * @version: $
 */
public class Leet114_flattern {

    TreeNode pre = null;
    //原地
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        // 前序遍历的 倒序    右 ——> 左 ——> 中

        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

}
