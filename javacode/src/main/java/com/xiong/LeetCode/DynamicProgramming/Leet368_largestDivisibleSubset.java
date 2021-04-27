package com.xiong.LeetCode.DynamicProgramming;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/4/23 11:15
 * @description：  368. 最大整除子集  dp ： dp[i] = max( dp[j] + 1 ) , j : 0...i
 * @modified By：
 * @version: $
 */
public class Leet368_largestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;

        // dp[i] 表示 以 nums[i] 为 最大整数的目标子集的长度
        int[] dp = new int[n];
        // 用于记录 路径， g[i] 表示 下标 i 的上一个节点 的下标
        int[] g = new int[n];
        // 先对数组排序
        Arrays.sort(nums);

        int maxSize = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int len = 1, prev = i;

            // dp 状态转移：如果 nums[i] 为 nums[j] 的倍数， 则 dp[i] = dp[j] + 1
            // 从 0...i 中找符合条件的 最大的 dp[j] + 1
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > len) {
                        len = dp[j] + 1;
                        prev = j;
                    }
                }
            }

            dp[i] = len;
            g[i] = prev;
            // 获得最大整除子集的 最大长度 和 子集中最大整数的下标 i
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                idx = i;
            }
        }

        LinkedList<Integer> ans = new LinkedList<>();
        // 通过路径数组 还原得出 最大整除子集
        while (ans.size() < maxSize) {
            ans.addFirst(nums[idx]);
            idx = g[idx];
        }

        return ans;
    }
}
