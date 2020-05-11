package com.xiong.LeetCode.BinaryTree;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/7 10:30
 * @description： 572. 另一个树的子树
 * @modified By：
 * @version: $
 */
public class Leet576_isSubtree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null){
            return false;
        }

        boolean root = isthesame(s, t);
        boolean left = isSubtree(s.left, t);
        boolean right = isSubtree(s.right, t);

        return root || left || right;
    }

    private boolean isthesame(TreeNode s, TreeNode t){
        if (s== null && t== null){
            return true;
        }
        if (s == null || t == null){
            return false;
        }

        if (s.val != t.val){
            return false;
        }

        return isthesame(s.left, t.left) && isthesame(s.right,t.right);
    }
}
