package com.xiong.LeetCode.BinaryTree;


import com.xiong.LeetCode.TreeNode;

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

    //第n次做
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }

        return isSymmetric(root.left,root.right);

    }
    //重载一下 方法即可
    private boolean isSymmetric(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null){
            return true;
        }
        if (t1 == null || t2 == null){
            return false;
        }

        return  t1.val == t2.val
                && isSymmetric(t1.left,t2.right)
                && isSymmetric(t1.right, t2.left);
    }





    public boolean isSymmetric_old(TreeNode root) {
        if(root == null){
            return true;
        }
      return  isSameval(root.left,root.right);

    }
    //判断左右两个子树是否对称
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
