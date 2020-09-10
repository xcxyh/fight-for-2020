package com.xiong.LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/11 18:18
 * @description： 39. 组合总和
 * @modified By：
 * @version: $
 */
public class Leet39_combinationSum {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        backtracking(candidates, 0, 0, new ArrayList<>(), target);
        return ans;
    }

    private void backtracking(int[] candidates, int sum, int cur, List<Integer> list, int target) {
        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }
        //剪枝
        if (sum > target) {
            return;
        }

        //解集不能包含重复的组合。 从 k 开始  不走回头路
        for (int i = cur; i < candidates.length; i++) {

            sum = sum + candidates[i];
            list.add(candidates[i]);
            backtracking(candidates, sum, i, list, target);
            list.remove(list.size() - 1);
            sum = sum - candidates[i];

        }

    }
}
