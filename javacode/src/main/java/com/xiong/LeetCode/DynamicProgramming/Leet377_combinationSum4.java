package com.xiong.LeetCode.DynamicProgramming;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/4/24 11:57
 * @description： 377. 组合总和 Ⅳ    dp : 类似背包问题
 * @modified By：
 * @version: $
 */
public class Leet377_combinationSum4 {
    public int combinationSum4(int[] nums, int target) {

        int[] dp = new int[target + 1];

        dp[0] = 1;

        for (int i = 0; i <= target; i++) {

            for (int x : nums) {

                if (x < i) {
                    dp[i] += dp[i - x];

                }
            }
        }

        return dp[target];
    }

}
