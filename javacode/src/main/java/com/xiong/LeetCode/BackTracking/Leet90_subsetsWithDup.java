package com.xiong.LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/9/20 10:50
 * @description：  90. 子集 II
 * @modified By：
 * @version: $
 */
public class Leet90_subsetsWithDup {


    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {


        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), 0, new boolean[nums.length]);

        return ans;
    }

    private void dfs(int[] nums, List<Integer> list, int cur, boolean[] visited) {

        ans.add(new ArrayList<>(list));

        if (cur == nums.length) {
            return;
        }

        for (int i = cur; i < nums.length;  i++) {
            if (visited[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i- 1] && !visited[i - 1]){
                continue;
            }

            list.add(nums[i]);
            visited[i] = true;
            dfs(nums, list, i + 1,visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }

    }
}
