package com.xiong.LeetCode.BinaryTree;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/16 14:36
 * @description： 给定两个非空二叉树 s 和 t，
 * 检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。
 * s 也可以看做它自身的一棵子树。
 * <p>
 * 示例 1:
 * 给定的树 s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * 给定的树 t：
 * <p>
 * 4
 * / \
 * 1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 * @modified By：
 * @version: $
 */
public class B5_IsSubTree {



   /**
    *  @author: xiongcong
    *  @Date: 2020/2/16 14:53
    *  @Description:  ac做法  但是空间和时间复杂度都极高
    */
    public boolean isSubTree(TreeNode s, TreeNode t) {
        if (s == null  && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }

        return isSameTree(s, t) || isSubTree(s.left, t) || isSubTree(s.right, t);

    }

    //判断两个树是否相同
    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null  && t == null) {
            return true;
        }
        if(s == null || t == null){
            return false;
        }
        return s.val == t.val && isSameTree(s.left,t.left) && isSameTree(s.right,t.right);

    }


}
