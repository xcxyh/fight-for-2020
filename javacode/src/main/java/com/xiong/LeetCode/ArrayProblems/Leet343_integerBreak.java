package com.xiong.LeetCode.ArrayProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/30 12:01
 * @description： 343. 整数拆分
 * @modified By：
 * @version: $
 */
public class Leet343_integerBreak {

    public int integerBreak_dp(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }

    // 数学方法
    public int integerBreak(int n) {
        if (n < 4) {
            return n - 1;
        }

        int m = n / 3;
        if (n % 3 == 1) {
            return (int) Math.pow(3, m - 1) * 4;
        }

        if (n % 3 == 0) {
            return (int) Math.pow(3, m);
        }

        return (int) Math.pow(3, m) * 2;
    }
}
