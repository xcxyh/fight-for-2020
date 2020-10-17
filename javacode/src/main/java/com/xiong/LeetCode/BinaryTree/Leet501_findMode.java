package com.xiong.LeetCode.BinaryTree;

import com.xiong.LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/9/24 10:59
 * @description： 501. 二叉搜索树中的众数
 * @modified By：
 * @version: $
 */
public class Leet501_findMode {


    private TreeNode pre = null;
    private List<Integer> list = new ArrayList<>();
    private int curCount = 1;
    private int max = 1;
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }

        inorder(root);

        int[] ans = new int[list.size()];

        for (int i = 0; i< list.size(); i++){
            ans[i] = list.get(i);
        }

        return ans;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        if (pre != null) {
            if (pre.val == root.val) {
                curCount++;
            }else{
                curCount = 1;
            }
        }
        if (max < curCount) {
            max = curCount;
            list.clear();
            list.add(root.val);
        }else if (max == curCount) {
            list.add(root.val);
        }

        pre = root;

        inorder(root.right);

    }


}
