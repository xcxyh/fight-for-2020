package com.xiong.LeetCode.BinaryTree;


/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/16 14:55
 * @description：
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * @modified By：
 * @version: $
 */
public class B6_isSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
      return  isSameval(root.left,root.right);

    }

    private boolean isSameval(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 == null || t2 == null){
            return false;
        }
      return   t1.val == t2.val && isSameval(t1.left,t2.right) && isSameval(t1.right,t2.left);
    }
}
