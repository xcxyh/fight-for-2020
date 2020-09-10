package com.xiong.LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/11 18:38
 * @description： 40. 组合总和 II
 * @modified By：
 * @version: $
 */
public class Leet40_combinationSum2 {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //  isVisted 保证 每个数字在每个组合中只能使用一次。
        boolean[] isVisted = new boolean[candidates.length];
        Arrays.sort(candidates); // 保证结果集 不重复
        backtracking(candidates, 0, 0, new ArrayList<>(), isVisted, target);
        return ans;
    }

    private void backtracking(int[] candidates,
                              int cur,
                              int index, // 保证 不走回头路
                              List<Integer> list,
                              boolean[] isVisted,
                              int target
    ) {

        if (cur == target) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (cur > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            if (isVisted[i]) {
                continue;
            }
            // 前提 是 要先对数组进行排序
            // 剪枝，判断 当前值和上一个的值相同时，上一个已经回溯完毕退出了，
            // 当前这个就不需要再 遍历了，防止重复
            if (i > 0 && candidates[i] == candidates[i - 1] && !isVisted[i - 1]) {
                continue;
            }

            cur = cur + candidates[i];
            isVisted[i] = true;
            list.add(candidates[i]);
            backtracking(candidates, cur, i, list, isVisted, target);
            cur = cur - candidates[i];
            isVisted[i] = false;
            list.remove(list.size() - 1);

        }


    }


    public List<List<Integer>> combinationSum20(int[] candidates, int target) {


        Arrays.sort(candidates);

        dfs(candidates, 0, 0, new ArrayList<>(), target, new boolean[candidates.length]);

        return ans;
    }

    private void dfs(int[] candidates, int sum, int cur, List<Integer> list, int target, boolean[] visited) {
        if (sum == target) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (sum > target) {
            return;
        }


        for (int i = cur; i < candidates.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) {
                continue;
            }

            visited[i] = true;

            sum += candidates[i];
            list.add(candidates[i]);
            dfs(candidates, sum, i, list, target, visited);
            sum -= candidates[i];
            list.remove(list.size() - 1);

            visited[i] = false;
        }
    }
}
