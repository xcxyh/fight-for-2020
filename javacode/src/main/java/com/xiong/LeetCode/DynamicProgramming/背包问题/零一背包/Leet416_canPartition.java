package com.xiong.LeetCode.DynamicProgramming.背包问题.零一背包;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/6/7 10:20
 * @description： 416. 分割等和子集  问题转化为：从数组中能否找出一组数 使得 和 为  sum / 2， 01 背包
 * @modified By：
 * @version: $
 */
public class Leet416_canPartition {

    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for (int x : nums) {
            sum += x;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        boolean[][] dp = new boolean[n][target + 1];
        //init
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < n; i++) {

            for (int j = 0; j <= target; j++) {

                dp[i][j] = dp[i - 1][j];

                if (j > nums[i]) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[n - 1][target];
    }
}
