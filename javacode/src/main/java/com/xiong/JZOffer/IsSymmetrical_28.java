package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/7 15:20
 * @description： 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * @modified By：
 * @version: $
 */
public class IsSymmetrical_28 {

    public static boolean isSymmetrical(TreeNode root){
        if(root == null){
            return true;
        }
        return sameValue(root.left,root.right);

    }
    public static boolean sameValue(TreeNode tree1, TreeNode tree2){
        if (tree1 == null && tree2 == null){
            return true;
        }
        if (tree1 == null || tree2 == null){
            return false;
        }
        if(tree1.val != tree2.val){
            return false;
        }

        return sameValue(tree1.left,tree2.right) && sameValue(tree1.right,tree2.left);
    }

}
