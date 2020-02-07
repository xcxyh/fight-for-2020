package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/7 15:13
 * @description： 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 * @modified By：
 * @version: $
 */
public class Mirror_27 {

    /**
     *  @author: xiongcong
     *  @Date: 2020/2/7 15:17
     *  @Description: 简单的递归思想
     */
    public static void Mirror(TreeNode root) {
        if(root != null ) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }else{
            return;
        }
        Mirror(root.left);
        Mirror(root.right);
    }
}
