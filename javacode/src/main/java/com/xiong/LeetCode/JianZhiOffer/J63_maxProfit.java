package com.xiong.LeetCode.JianZhiOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/2 9:47
 * @description： 面试题63. 股票的最大利润  DP 问题
 * @modified By：
 * @version: $
 */
public class J63_maxProfit {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0){
            return 0;
        }
        int n = prices.length;
        int[] dp = new int[n]; //前 i 天 的最大 利润

        int minBuy = prices[0];

        for(int i = 1; i < n; i++){
            if (prices[i] < minBuy){
                minBuy = prices[i];
            }
            int cur = prices[i] > minBuy ? prices[i] - minBuy : 0;
            dp[i] = Math.max(dp[i - 1], cur);
        }
        return dp[n - 1];
    }
}
