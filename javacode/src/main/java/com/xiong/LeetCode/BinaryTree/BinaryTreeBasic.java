package com.xiong.LeetCode.BinaryTree;


/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/12 15:37
 * @description：  二叉树基础性质相关  使用递归
 * @modified By：
 * @version: $
 */
public class BinaryTreeBasic {
   private boolean result = true;
    /**
     *  @author: xiongcong
     *  @Date: 2020/2/12 16:44
     *  @Description:   1 求二叉树深度
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
     *  @Description:  2 平衡树 ：左右子树高度差都小于等于 1
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
    /**
     *  @author: xiongcong
     *  @Date: 2020/2/15 11:01
     *  @Description: 3 求二叉树的直径
     */
    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }
    public int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        diameter = Math.max(diameter, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     *  @author: xiongcong
     *  @Date: 2020/2/15 11:26
     *  @Description: 4 翻转二叉树  递归
     */
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode root){
        if(root == null){
            return;
        }
        //交换左右子树的节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //递归左右
        invertTree(root.left);
        invertTree(root.right);
    }

    //或者
    private TreeNode invertTree2(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode left = root.left;
        root.left = invertTree2(root.right);
        root.right = invertTree(left);
        return root;
    }

}
