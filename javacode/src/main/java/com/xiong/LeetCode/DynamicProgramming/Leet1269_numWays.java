package com.xiong.LeetCode.DynamicProgramming;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/5/13 10:26
 * @description： 1269. 停在原地的方案数   二维dp  dp[i][j] 走 i 步 到达位置 j 的方案数 ， 当前状态只与上一步的状态有关
 * 取模的时候，注意 每两个数相加 就要取一次模
 * 转移方程：dp[i][j] = ((dp[i - 1][j - 1] + dp[i-1][j]) % mod + dp[i-1][j + 1]) % mod;
 * @modified By：
 * @version: $
 */
public class Leet1269_numWays {

    public int numWays(int steps, int arrLen) {
        // 走 i 步 到达位置 j 的方案数
        int maxColumn = Math.min(arrLen - 1, steps);
        int[][] dp = new int[steps + 1][maxColumn + 1];
        int mod = 1000000007;
        dp[0][0] = 1;

        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= maxColumn; j++) {

                if (j > 0 && j < maxColumn) {
                    dp[i][j] = ((dp[i - 1][j - 1] + dp[i-1][j]) % mod + dp[i-1][j + 1]) % mod;
                }else if (j == 0) {
                    dp[i][j] = (dp[i-1][j] + dp[i-1][j + 1]) % mod;
                }else if (j == maxColumn) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i-1][j]) % mod;
                }

            }
        }

        return dp[steps][0] % mod;

    }
}
