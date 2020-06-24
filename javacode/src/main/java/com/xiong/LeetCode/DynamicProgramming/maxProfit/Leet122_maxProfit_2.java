package com.xiong.LeetCode.DynamicProgramming.maxProfit;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/23 21:45
 * @description： 122. 买卖股票的最佳时机 II
 * @modified By：
 * @version: $
 */
public class Leet122_maxProfit_2 {

    // dp  这是 6 道 股票问题 的通用解法
    // 由于状态转移时 只与上一个状态有关 ，所以可以进行状态压缩，变成 O(1) 空间复杂度
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        // 此时相当于  k 为 无穷大， 即 与 买卖次数 k 无关
        int[][] dp = new int[n][2]; // 0 表示 没有持有股票  1 表示持有

        //int dp_i_0 = 0; int dp_i_1 = Integer.MIN_VALUE;

        //init
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //temp = dp_i_0  上一轮的结果保存一下
            // dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            // dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }

        return  dp[n  - 1][0];
    }

    // 状态压缩版
    int maxProfit_dp(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }
        return dp_i_0;
    }


    //贪心做法, 只要 明天的价格比今天高 ， 我就 今天买入，明天卖出
    private int greedy(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int maxProfit = 0;

        for (int i = 0; i < n - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                maxProfit += (prices[i + 1] - prices[i]);
            }
        }
        return maxProfit;
    }
}
