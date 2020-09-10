package com.xiong.LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/9/8 10:09
 * @description： 77. 组合
 * @modified By：
 * @version: $
 */
public class Leet77_combine {


    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        dfs(n, k, 1, new ArrayList<>());

        return ans;
    }

    private void dfs(int n, int k, int cur, List<Integer> list) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = cur; i <= n; i++) {
            list.add(i);
            dfs(n, k, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
