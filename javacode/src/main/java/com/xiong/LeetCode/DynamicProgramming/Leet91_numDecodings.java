package com.xiong.LeetCode.DynamicProgramming;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/4/21 12:18
 * @description： 91. 解码方法   dp
 * @modified By：
 * @version: $
 */
public class Leet91_numDecodings {

    public int numDecodings(String s) {
        int n = s.length();

        if (s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[n + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1) {
                int num1 = s.charAt(i - 2) - '0';
                int num2 = s.charAt(i - 1) - '0';
                if (num1 != 0 && (num1 * 10 + num2 <= 26)) {
                    dp[i] += dp[i - 2];
                }
            }

        }

        return dp[n];
    }
}
