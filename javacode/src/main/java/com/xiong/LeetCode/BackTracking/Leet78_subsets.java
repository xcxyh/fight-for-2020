package com.xiong.LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/9/1 16:11
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet78_subsets {

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {

        dfs(nums, 0, new ArrayList<>());

        return ans;

    }

    private void dfs(int[] nums, int cur, List<Integer> list){

        ans.add(new ArrayList<>(list));

        if (cur == nums.length) {
            return;
        }

        for (int i  =cur; i < nums.length ; i++) {

            list.add(nums[i]);
            dfs(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
