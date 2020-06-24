package com.xiong.LeetCode.DynamicProgramming.maxProfit;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/23 21:48
 * @description： 123. 买卖股票的最佳时机 III  买卖次数 k 为 2 次
 * @modified By：
 * @version: $
 */
public class Leet123_maxProfit_3 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int max_k = 2; // 最多可交易的次数
        int n = prices.length;
        int[][][] dp = new int[n][max_k + 1][2];
        // 交易次数 最多为 0 次 不允许交易


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


    // 状态压缩版
    int maxProfit_k_2(int[] prices) {
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);
        }
        return dp_i20;
    }
}
