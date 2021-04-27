package com.xiong.LeetCode.DynamicProgramming;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/3/17 9:51
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet115_numDistinct {

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m < n) {
            return 0;
        }
        // dp[i][j] 表示 s[i:] 中  t[j:] 作为子序列的个数
        int[][] dp = new int[m + 1][n + 1];

        // 当 t[j:] 为空串时，空串为所有字符串的子串
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                dp[i][j] = dp[i + 1][j];

                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] += dp[i + 1][j + 1];
                }

            }
        }

        return dp[0][0];

    }
}
