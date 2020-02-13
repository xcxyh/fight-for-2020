package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/5 13:22
 * @description： 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 * @modified By：
 * @version: $
 */
public class J26_HasSubtree {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        if (root1 == null || root2 == null) {
            return false;
        }

        return isSubTreeWithRoot(root1, root2) ||  //根节点相同时
                HasSubtree(root1.left, root2) || //根节点不同  去左子树中寻找
                HasSubtree(root1.right, root2); //根节点不同  去右子树中寻找

    }


    public static boolean isSubTreeWithRoot(TreeNode root1, TreeNode root2) {
        //如果root2还没有遍历完，root1却遍历完了。返回false
        if (root1 == null) {
            return false;
        }
        //如果root2已经遍历完了都能对应的上，返回true
        if (root2 == null) {
            return true;
        }
        //不相等直接为false
        if(root1.val != root2.val){
            return false;
        }
        //分别判断root 的左右是否分别相等
        return isSubTreeWithRoot(root1.left, root2.left) &&
                isSubTreeWithRoot(root1.right, root2.right);
    }

}
