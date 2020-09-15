package com.xiong.LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/9/11 9:45
 * @description： 216. 组合总和 III
 * @modified By：
 * @version: $
 */
public class Leet216_combinationSum3 {

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {

        dfs(k, n, 1, 0, new ArrayList<>());
        return ans;
    }


    private void dfs(int k, int n, int cur,int sum, List<Integer> list){

        if (list.size() == k && sum == n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (sum > n) {
            return;
        }


        for (int i = cur; i <= 9; i++) {

            list.add(i);
            sum += i;
            dfs(k, n, i + 1, sum, list);
            list.remove(list.size() - 1);
            sum -= i;
        }
    }
}
