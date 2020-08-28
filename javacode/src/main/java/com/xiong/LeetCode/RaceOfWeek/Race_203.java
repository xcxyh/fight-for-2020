package com.xiong.LeetCode.RaceOfWeek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/23 12:13
 * @description： 又成两题选手了
 * @modified By：
 * @version: $
 */
public class Race_203 {
    // 1 圆形赛道上经过次数最多的扇区

    public List<Integer> mostVisited(int n, int[] rounds) {
        int start = rounds[0];
        int end = rounds[rounds.length - 1];
        List<Integer> ans = new ArrayList<>();
        if (start <= end) {
            for (int j = start; j <= end; j++) {
                ans.add(j);
            }

        } else {

            for (int j = 1; j <= end; j++) {
                ans.add(j);
            }
            for (int j = start; j <= n; j++) {
                ans.add(j);
            }

        }

        return ans;
    }

    //2   你可以获得的最大硬币数目
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);

        int ans = 0;
        int left = 0;
        int right = piles.length - 1;
        while (left < right) {
            if (right > 1) {
                ans += piles[--right];
            }

            left++;
            right--;
        }
        return ans;
    }

    //3  查找大小为 M 的最新分组  反向遍历 想到了， 但是 不知道 treeSet 的lower 和higher 方法
    // 没有在 O(1) 复杂度 找到 边界

    public int findLatestStep(int[] arr, int m) {
        TreeSet<Integer> set = new TreeSet<>();
        int n = arr.length;
        set.add(0);
        set.add(n + 1);
        if (n == m) return n;
        for (int i = n - 1; i >= 0; i--) {
            int cur = arr[i];
            int left = set.lower(cur);
            int right = set.higher(cur);
            if (cur - left - 1 == m || right - cur - 1 == m) {
                return i;
            }
            set.add(cur);
        }
        return -1;
    }

    // 4 石子游戏 V  , 好简单啊 ，早知道先做这题了 我吐了

    private int[] sum;
    private Integer[][] memo;

    public int stoneGameV(int[] stoneValue) {

        int n = stoneValue.length;

        sum = new int[n + 1];
        memo = new Integer[n + 1][n + 1];
        // 求前缀和
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + stoneValue[i - 1];
        }

        return dp(0, n);
    }

    //[ )  注意这个边界
    private int dp(int l, int r) {
        if (l >= r) {
            return 0;
        }
        if (memo[l][r] != null) {
            return memo[l][r];
        }

        int max = 0;
        for (int i = l + 1; i < r; i++) {
            int score = 0;
            int left = sum[i] - sum[l];
            int right = sum[r] - sum[i];
            if (left < right) {
                score = left + dp(l, i);
            } else if (left > right) {
                score = right + dp(i, r);
            } else {
                score = left + Math.max(dp(l, i), dp(i, r));
            }
            max = Math.max(max, score);
        }
        memo[l][r] = max;
        return max;
    }

}
