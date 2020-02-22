package com.xiong.LeetCode.BinarySearchTree;

import com.xiong.LeetCode.TreeNode;

import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/22 15:00
 * @description： 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点
 * 的左右两个子树的高度差的绝对值不超过 1。
 * @modified By：
 * @version: $
 */
public class B6_sortedArrayToBST {

    public static void main(String[] args) {
        new B6_sortedArrayToBST().sortedArrayToBST(new int[]{1,2,3,4,5});
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0,nums.length -1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int from, int to) {
        TreeNode root;
        int mid = (from + to) / 2;
        if (from > to) {
            return null;
        }
        root = new TreeNode(nums[mid]);
        //注意 选定的 nums 的范围
        root.left = sortedArrayToBST(nums, from, mid -1);
        root.right = sortedArrayToBST(nums, mid + 1 , to);
        return root;
    }


}
