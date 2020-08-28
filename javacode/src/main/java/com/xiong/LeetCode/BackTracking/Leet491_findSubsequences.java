package com.xiong.LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/25 9:23
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet491_findSubsequences {


    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length < 2) {
            return ans;
        }

        backtracking(nums, new ArrayList<>(), 0);

        return ans;
    }

    // cur 不走回头路
    private void backtracking(int[] nums, List<Integer> list, int cur){
        if (list.size() >= 2){
            ans.add(new ArrayList<>(list));
        }

        if (cur == nums.length){
            return;
        }
        // 用于去重
        Set<Integer> set = new HashSet<>();
        for(int i = cur; i < nums.length; i++){

            if (set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);

            // 判断递增
            if (list.size() < 1 || list.get(list.size() - 1) <= nums[i]){
                list.add(nums[i]);
                backtracking(nums, list, i + 1);
                list.remove(list.size() - 1);
            }


        }
    }
}
