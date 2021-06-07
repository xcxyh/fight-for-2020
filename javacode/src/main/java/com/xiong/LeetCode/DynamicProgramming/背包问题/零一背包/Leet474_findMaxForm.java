package com.xiong.LeetCode.DynamicProgramming.背包问题.零一背包;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/6/6 11:53
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet474_findMaxForm {

    public int findMaxForm(String[] strs, int m, int n) {


        int len = strs.length;
        // 01 背包
        int[][][] dp = new int[len + 1][m + 1][n + 1];

        for (int i = 1; i <= len; i++) {

            int[] zos = getZos(strs[i - 1]);
            int zeros = zos[0], ones = zos[1];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }

        return dp[len][m][n];
    }

    private int[] getZos(String str) {

        int[] zos = new int[2];

        for (char c : str.toCharArray()) {

            zos[c - '0']++;
        }
        return zos;
    }

}
