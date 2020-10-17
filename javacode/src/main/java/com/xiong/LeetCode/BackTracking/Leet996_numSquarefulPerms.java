package com.xiong.LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/9/18 9:53
 * @description： 996. 正方形数组的数目
 * @modified By：
 * @version: $
 */
public class Leet996_numSquarefulPerms {

    private int ans = 0;

    public int numSquarefulPerms(int[] A) {

        int n = A.length;

        Arrays.sort(A);
        dfs(A, new ArrayList<>(), new boolean[n]);
        return ans;

    }

    private void dfs(int[] A, List<Integer> list, boolean[] visited) {

        // 改进，先判断，防止超时
        if (!check(list)) {
            return;
        }

        if (list.size() == A.length) {
            ans++;
            return;
        }

        for (int i = 0; i < A.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (i > 0 && A[i] == A[i - 1] && !visited[i - 1]) {
                continue;
            }

            list.add(A[i]);
            visited[i] = true;
            dfs(A, list, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    private boolean check(List<Integer> list) {

        for (int i = 0; i < list.size() - 1; i++) {
            int a = list.get(i);
            int b = list.get(i + 1);
            int x = (int) Math.sqrt(a + b);
            if (x * x != a + b) {
                return false;
            }
        }
        return true;
    }
}
