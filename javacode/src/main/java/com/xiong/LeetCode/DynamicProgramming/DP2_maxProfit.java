package com.xiong.LeetCode.DynamicProgramming;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/30 13:52
 * @description：   买卖股票的最佳时机
 * @modified By：
 * @version: $
 */
public class DP2_maxProfit {

    public int maxProfit(int[] prices) {
        if( prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int minbuy = prices[0];
        int[] dp = new int[n];
        //dp[i] 表示 从第1天到 第 i 天 的最大利润，使用minbuy 记录最小买入
        for(int i = 1; i <n; i++){
            if(prices[i] < minbuy){
                minbuy = prices[i];
            }
            dp[i] = Math.max(prices[i]-minbuy,dp[i-1]); // 状态 计算
        }
        return dp[n -1];
    }
}
