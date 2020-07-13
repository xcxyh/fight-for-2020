package com.xiong.LeetCode.DynamicProgramming;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/5 15:15
 * @description： 44. 通配符匹配
 * @modified By：
 * @version: $
 */
public class Leet44_isMatch {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        //init  当 s 为 "" , p 只能是 "" 或者 全是 ****
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) != '*') {
                break;
            }
            dp[0][i] = true;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];

                } else if (p.charAt(j - 1) == '*') {

                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[m][n];


    }
}
