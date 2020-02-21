package com.xiong.LeetCode.BinarySearchTree;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/21 15:46
 * @description：
 *  二叉搜索树 的特点：
 *  特征一:
 * 任意结点（包括根结点）的左子树上的结点的值都比这个结点得值小。
 * 特征二：
 * 任意结点（包括根结点）的右子树上的结点的值都比这个结点得值大。
 * 特征三:
 * 没有值相等的点。
 * 特征四:
 * 二叉搜索树 中序遍历 结果 单调递增
 *
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * @modified By：
 * @version: $
 */
public class B2_kthSmallest {

    //利用中序遍历  返回 中序遍历结果中的第k个即可
    private int count = 0;
    private int result;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k );
        return result;
    }
    private void inorder(TreeNode root, int k){
        if (root == null){
            return;
        }
        //中
        inorder(root.left, k);
        //根
        count++;
        if (count == k){
            result = root.val;
            return;
        }
        //右
        inorder(root.right,k);

    }
}
