package com.xiong.LeetCode.StackAndQueue;

import java.awt.image.SinglePixelPackedSampleModel;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/19 16:45
 * @description： 494. 目标和
 * @modified By：
 * @version: $
 */
public class Leet494_findTargetSumWays {

    public static void main(String[] args) {



        System.out.println(findTargetSumWays_dp(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, 0, 0, S);
        return ans;
    }

    /**
     * @author: xiongcong
     * @Date: 2020/4/19 16:48
     * @Description: dfs 深度优先遍历
     */
    private int ans = 0;

    private void dfs(int[] nums, int cur, int sum, int target) {
        if (cur == nums.length) {
            if (sum == target) {
                ans++;
            }
            return;
        }
        dfs(nums, cur + 1, sum + nums[cur], target);
        dfs(nums, cur + 1, sum - nums[cur], target);
    }

    /**
     * @author: xiongcong
     * @Date: 2020/4/19 17:31
     * @Description: dp  转化为 01 背包问题 （懵）
     * // Time:O(n^2) Space:O(n)
     */
    public static int findTargetSumWays_dp(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int len = nums.length;
        // 正数和子集 数 为 小数 则不存在
        // S_+  -  S_-  = S  ---->  2 * S_+ = S + (S_+ + S_-)
        // -------->  2 * S_+ = S + sum(nums)
        if ((sum + S) % 2 == 1) {
            return 0;
        }
        int k = (sum + S) / 2;
        //dp[j]  表示 得到 和 为 j 的 方案数
        //dp[j] += dp[j-nums[i]]
        //以下是01 背包优化版
        int[] dp = new int[len + 1];
        dp[0] =1;
        for (int num : nums) {
            for (int j = k; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[k];
    }
}
