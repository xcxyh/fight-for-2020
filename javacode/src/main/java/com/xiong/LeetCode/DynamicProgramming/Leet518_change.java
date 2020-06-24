package com.xiong.LeetCode.DynamicProgramming;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/17 11:24
 * @description： 518. 零钱兑换 II  完全背包问题
 * @modified By：
 * @version: $
 */
public class Leet518_change {


    // 二维dp 做了 时间上的优化
    public int change_2(int amount, int[] coins) {

        //dp[i][j] 表示 使用前 i 种 面值 硬币，凑成总金额 j 的 组合数
        //
        int m = coins.length;
        int[][] dp = new int[m + 1][amount + 1];

        //init
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= amount; j++) {

                dp[i][j] = dp[i - 1][j]; // dp[i][j] =  dp[i - 1][j] +

                // dp[i - 1][j- m[i]] + dp[i - 1][j- 2 * m[i]] .... == dp[i][ j - m[i] ];
                if (j >= coins[i - 1]) { // 注意这里是coins[i - 1]
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }

            }
        }
        return dp[m][amount];

    }


    //最优解法  优化成了 一维 dp 和 n^2 复杂度
    public int change_3(int amount, int[] coins) {

        //dp[i][j] 表示 使用前 i 种 面值 硬币，凑成总金额 j 的 组合数
        //
        //int m = coins.length;
        int[] dp = new int[amount + 1];
        //init
        dp[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];

    }
}
