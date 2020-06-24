package com.xiong.LeetCode.DynamicProgramming.maxProfit;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/24 10:56
 * @description： 714. 买卖股票的最佳时机含手续费  122 变种
 * @modified By：
 * @version: $
 */
public class Leet714_maxProfit_2_2 {

    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        // dp[i][0] 表示 第 i 天 不持有股票 ，手上的钱
        // dp[i][1] 表示 第 i 天 持有股票 ，手上的钱
        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n ; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i -1][1] + prices[i] - fee); // 卖出时交手续费
            // 当然，也可以 买入时缴纳 ，重点是 只交一次手续费
            dp[i][1] = Math.max(dp[i - 1][1], dp[i -1][0] - prices[i]);
        }

        return dp[n - 1][0];

    }

    // 状态压缩版
    int maxProfit_with_fee(int[] prices, int fee) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i] - fee);
        }
        return dp_i_0;
    }
}
