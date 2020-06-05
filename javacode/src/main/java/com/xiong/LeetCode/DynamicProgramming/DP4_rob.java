package com.xiong.LeetCode.DynamicProgramming;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/30 15:06
 * @description： 198. 打家劫舍
 * @modified By：
 * @version: $
 */
public class DP4_rob {


    //第3次做
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) { // 注意
            return nums[0];
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]); // 注意
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[len - 1];
    }


    /**
     * @author: xiongcong
     * @Date: 2020/3/30 15:07
     * @Description: 动态规划
     */
    public int rob_dp(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int[] dp = new int[n];
        //dp[i] 表示从 开始 到 i 的最大金额
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }


    /**
     * @author: xiongcong
     * @Date: 2020/3/30 15:06
     * @Description: 递归也可以做
     */
    public int robR(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int r1 = rob(nums, i);
            max = Math.max(max, r1);
        }
        return max;
    }

    private int rob(int[] nums, int begin) {
        if (begin >= nums.length) {
            return 0;
        }
        int r1 = rob(nums, begin + 2);
        int r2 = rob(nums, begin + 3);
        return nums[begin] + Math.max(r1, r2);
    }
}
