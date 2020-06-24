package com.xiong.LeetCode.DynamicProgramming.maxProfit;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/24 10:53
 * @description：  188. 买卖股票的最佳时机 IV  买卖次数为 k 次
 * @modified By：
 * @version: $
 */
public class Leet188_maxProfit_4 {

    public int maxProfit(int k, int[] prices) {

        if (prices == null || prices.length < 2) {
            return 0;
        }
        int max_k = k; // 最多可交易的次数
        int n = prices.length;
        // 如果 k > n / 2 那么 k 就没有约束作⽤了
        if (max_k > n / 2) {
            return maxProfit_2(prices);
        }

        // 以下  与 第三题 一模一样

        int[][][] dp = new int[n][max_k + 1][2];

        //init  注意这里的初始化 ，与 k 是无关的
        for (int j = max_k; j >= 1; j--) {
            dp[0][j][0] = 0;
            dp[0][j][1] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = max_k; j >= 1; j--) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                //选择 buy 的时候，把 k 减⼩了 1
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        return dp[n - 1][max_k][0];
    }

    // 第二题，即 k 为 无穷大， 不限制交易次数的情况
    private int maxProfit_2(int[] prices){

        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;

        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = - prices[0];

        for (int i = 1; i < n ; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i -1][1] + prices[i]);

            dp[i][1] = Math.max(dp[i - 1][1], dp[i -1][0] - prices[i]);
        }

        return dp[n - 1][0];
    }
}
