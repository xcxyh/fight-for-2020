package com.xiong.LeetCode.DynamicProgramming.区间DP;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/5/24 11:00
 * @description：664. 奇怪的打印机  Hard
 * @modified By：
 * @version: $
 */
public class Leet664_strangePrinter {

    public int strangePrinter(String s) {
        int n = s.length();
        // dp[i][j] 代表打印在区间[i, j]内的字符 所需的最小次数
        int[][] dp = new int[n][n];
        // 转移：
        // 1 区间两端字符相同  在打印第一个字符时，顺带打印最后一个， 即 只需打印前一部分 dp[i][j] = dp[i][j - 1];
        // 2 区间两端字符不同  就分左右两部分打印， 枚举所有的 分成左右两部分的情况，取最小的
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i][j - 1];
                }else {
                    int temp = 10000;
                    for (int k = i ; k < j; k++ ) {
                        temp = Math.min(temp, dp[i][k] + dp[k + 1][j]);
                    }
                    dp[i][j] = temp;
                }

            }
        }

        return dp[0][n - 1];
    }
}
