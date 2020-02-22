package com.xiong.LeetCode.BinarySearchTree;

import com.xiong.LeetCode.TreeNode;

import java.util.ArrayList;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/22 16:29
 * @description： 给定一个二叉搜索树和一个目标结果，
 * 如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 使用中序遍历得到有序数组之后，再利用双指针对数组进行查找。
 * 转化成数组的 两数之和问题
 * @modified By：
 * @version: $
 */
public class B8_findTarget {
    private ArrayList<Integer> nums = new ArrayList<>();
    public boolean findTarget(TreeNode root, int target) {
        inorder(root);
        int index1 = 0;
        int index2 = nums.size() -1;
       while (index1 < index2){
            int cur = nums.get(index1) + nums.get(index2);
            if (cur < target){
                index1++;
            }
            if (cur > target){
                index2--;
            }
            if (cur == target){
                return true;
            }
        }
        return false;

    }

    private void inorder(TreeNode root){
        if (root == null){
            return;
        }
        inorder(root.left);
        nums.add(root.val);
        inorder(root.right);

    }
}
