package com.xiong.LeetCode.BinaryTree;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/17 17:10
 * @description： 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
 * 如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * @modified By：
 * @version: $
 */
public class B11_findSecondMinimumValue {

    public int findSecondMinimumValue(TreeNode root) {

        if (root == null) {
            return -1;
        }
        if (root.left == null || root.right == null) {
            return -1;
        }
        int leftval = root.left.val;
        int rightval = root.right.val;
        //找到左子树中第一个大于根节点的值
        if(leftval == root.val){
            leftval = findSecondMinimumValue(root.left);
        }
        //找到右子树中第一个大于根节点的值
        if(rightval == root.val){
            rightval = findSecondMinimumValue(root.right);
        }
        //左右都找到了 第二小的值
        if (leftval != -1 && rightval != -1){
            return Math.min(leftval,rightval);
        }
        if (leftval != -1){
            return leftval;
        }else{
            return rightval;
        }

    }
}
