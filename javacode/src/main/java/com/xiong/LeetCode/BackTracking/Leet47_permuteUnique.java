package com.xiong.LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/25 11:03
 * @description： 47. 全排列 II
 * @modified By：
 * @version: $
 */
public class Leet47_permuteUnique {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0){
            ans.add(new ArrayList<>());
            return ans;
        }
        //首先给数组排序  必须排序 不然 无法剪枝
        Arrays.sort(nums);
        backtracking(nums, new ArrayList<>(), new boolean[nums.length]);
        return ans;
    }
    private void backtracking(int[] nums, List<Integer> list, boolean[] visited ){
        if (list.size() == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if (visited[i]){
                continue;
            }

            // 剪枝 当前起点 与前一个相同 前一个已经回溯完毕退出了，为了不重复，
            // 以当前点为 起点的情况 就 直接跳过
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]){
                continue;
            }

            //backtracking
            visited[i] = true;
            list.add(nums[i]);
            backtracking(nums, list, visited);
            list.remove(list.size() - 1);
            visited[i] = false;

        }
    }


}
