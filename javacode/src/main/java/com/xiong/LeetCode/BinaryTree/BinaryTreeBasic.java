package com.xiong.LeetCode.BinaryTree;


/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/12 15:37
 * @description：  二叉树基础性质相关
 * @modified By：
 * @version: $
 */
public class BinaryTreeBasic {
   private boolean result = true;
    /**
     *  @author: xiongcong
     *  @Date: 2020/2/12 16:44
     *  @Description:  求二叉树深度
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;

    }
    /**
     *  @author: xiongcong
     *  @Date: 2020/2/12 16:45
     *  @Description: 平衡树左右子树高度差都小于等于 1
     */ 
    public boolean isBalanced(TreeNode root) {
        maxDepth2(root);
        return result;
        
    }
    public int maxDepth2(TreeNode root) {
        if(root == null){
            return 0;
        }
        int l_depth = maxDepth2(root.left);
        int r_depth = maxDepth2(root.right);
        if(Math.abs(l_depth - r_depth) > 1){
            result = false;
        }
        return Math.max(l_depth,r_depth) + 1;

    }
}
