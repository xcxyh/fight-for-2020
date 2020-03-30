package com.xiong.LeetCode.DynamicProgramming;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/30 11:49
 * @description： 爬楼梯  dp  递归 都可以 递归会有重复计算的问题
 * @modified By：
 * @version: $
 */
public class DP1_climbStairs {
    public int climbStairs(int n) {
        if(n == 0){
            return 1;
        }
        if(n <=2){
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
