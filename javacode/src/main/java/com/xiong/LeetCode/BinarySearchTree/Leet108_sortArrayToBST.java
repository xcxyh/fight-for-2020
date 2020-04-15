package com.xiong.LeetCode.BinarySearchTree;

import com.xiong.LeetCode.TreeNode;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/14 18:27
 * @description： 将有序数组转换为二叉搜索树
 * 利用二分的思想
 * @modified By：
 * @version: $
 */
public class Leet108_sortArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        return sortedArrayToBST(nums,0,nums.length -1 );
    }

    private TreeNode sortedArrayToBST(int[] nums,int low, int high) {
        if(low > high){
            return null;
        }
        //利用二分的思想
        int mid = low + (high -low) /2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left =  sortedArrayToBST(nums,low,mid - 1);
        root.right =  sortedArrayToBST(nums,mid + 1,high);

        return root;
    }
}
