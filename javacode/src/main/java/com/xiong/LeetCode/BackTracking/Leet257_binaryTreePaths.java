package com.xiong.LeetCode.BackTracking;

import com.xiong.LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/9/4 13:22
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet257_binaryTreePaths {

    List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {

        preorder(root,new ArrayList<>());
        return ans;
    }

    private void preorder(TreeNode root, List<String> list){
        if (root == null) {
            return;
        }
        list.add(root.val + "");
        if (root.left == null && root.right == null) {
            ans.add(String.join("->", list));
        }
        preorder(root.left, list);
        preorder(root.right, list);
        list.remove(list.size() - 1);
    }
}
