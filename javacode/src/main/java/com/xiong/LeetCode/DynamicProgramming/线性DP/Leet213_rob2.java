package com.xiong.LeetCode.DynamicProgramming.线性DP;

import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/23 18:45
 * @description：213. 打家劫舍 II
 * @modified By：
 * @version: $
 */
public class Leet213_rob2 {
    // 方法一： DP
    // 不偷 第一个房间 的结果
    // 不偷 最后一个房间 的结果
    // 取这两个结果的最大值
    public int rob_dp(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(rob1(nums, 0, n - 2), rob1(nums, 1, n - 1));
    }

    private int rob1(int[] nums, int start, int end) {
        int dp1 = nums[start], dp2 = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++) {
            int temp = Math.max(dp1 + nums[i], dp2);
            dp1 = dp2;
            dp2 = temp;
        }

        return dp2;
    }

    // 方法二： 递归 + 备忘录
    private Integer[][] memo;

    public int rob_memo(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;
        memo = new Integer[n][n];
        return Math.max(rob2(nums, 0, n - 2), rob2(nums, 1, n - 1));
    }

    private int rob2(int[] nums, int cur, int end) {

        if (cur > end) {
            return 0;
        }

        if (memo[cur][end] != null) {
            return memo[cur][end];
        }

        memo[cur][end] = Math.max(nums[cur] + rob2(nums, cur + 2, end), rob2(nums, cur + 1, end));

        return memo[cur][end];
    }
}
