package com.xiong.LeetCode.DynamicProgramming;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/18 22:08
 * @description： 97. 交错字符串  给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * @modified By：
 * @version: $
 */
public class Leet97_isInterleave {



    public static boolean isInterleave(String s1, String s2, String s3) {

        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }

        int m = s1.length();
        int n = s2.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        //init
        // for(int i = 1; i <= m; i++){
        //            dp[i][0] = dp[i -1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        //        }
        //        for(int j = 1; j <= n; j++){
        //            dp[0][j] =  dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        //        }

        // dp[i][j]  表示 s1 前 i 个元素 和 s2 前 j 个元素 能否组成 s3 的前 i+ j 个元素
        // 状态转移  s1 第 i 个元素 下标 是 i-1 , 同样的， s3 第 i + j 个元素 下标 为  i + j - 1
        // dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
        //           || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
                }

                if (i > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }

            }
        }

        return dp[m][n];

    }
}
