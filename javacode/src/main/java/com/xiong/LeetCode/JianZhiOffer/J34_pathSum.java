package com.xiong.LeetCode.JianZhiOffer;

import com.xiong.LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/6 18:56
 * @description：  面试题34. 二叉树中和为某一值的路径   回溯
 * @modified By：
 * @version: $
 */
public class J34_pathSum {

    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null){

            return ans;
        }
        dfs(root,new ArrayList<>(), sum);
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> list, int sum){

        if (root == null){
            return;
        }

        int val = root.val;
        sum = sum - val;
        list.add(val);

        if (sum == 0 && root.left == null && root.right == null){
            ans.add(new ArrayList<>(list));
            //这里不能return  不然    list.remove(list.size() - 1); 执行不到 无法回退
        } else{
            dfs(root.left, list, sum);
            dfs(root.right, list, sum);
        }

        if (list.size() != 0){
            list.remove(list.size() - 1);
        }



    }
}
