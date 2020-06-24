package com.xiong.LeetCode.DynamicProgramming.maxProfit;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/24 10:56
 * @description： 309. 最佳买卖股票时机含冷冻期  122 的变种
 * @modified By：
 * @version: $
 */
public class Leet309_maxProfit_2_1 {


    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        // dp[i][0] 表示 第 i 天 不持有股票 ，手上的钱
        // dp[i][1] 表示 第 i 天 持有股票 ，手上的钱
        int[][] dp = new int[n][2];

        //init
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        // 昨天不操作， 或者 昨天买入 今天卖出
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        // 昨天买入 或 今天买入 （因为 昨天卖出 今天买入的操作是不允许的）
        dp[1][1] = Math.max(dp[0][1], - prices[1]);

        for(int i = 2; i < n; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);

            //第 i 天选择 buy 的时候，要从 i-2 的状态转移，⽽不是 i-1
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }

        return dp[n - 1][0];
    }



    // 状态压缩版
    int maxProfit_with_cool(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0; // 代表 dp[i-2][0]
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = temp;
        }
        return dp_i_0;
    }

}
