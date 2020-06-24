package com.xiong.LeetCode.DynamicProgramming.maxProfit;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/30 13:52
 * @description：   买卖股票的最佳时机
 * @modified By：
 * @version: $
 */
public class Leet121_maxProfit_1 {


    public int maxProfit(int[] prices){

        if( prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            // 由于只能买卖一次
            // 昨天买入，今天无操作  或者  昨天无操作， 今天买入
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }

    //状态压缩版
    public int maxProfit_dp(int[] prices) {
        if( prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;

        //int[][] dp = new int[n][2]; // 0 表示 没有持有股票  1 表示持有

        int dp_i_0 = 0; int dp_i_1 = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            // dp[i][1] = max(dp[i-1][1], -prices[i])
            dp_i_1 = Math.max(dp_i_1, - prices[i]);
        }


        return dp_i_0;
    }
}
