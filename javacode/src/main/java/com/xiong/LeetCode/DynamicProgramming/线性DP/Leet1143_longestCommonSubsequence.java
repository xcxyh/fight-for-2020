package com.xiong.LeetCode.DynamicProgramming.线性DP;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/23 18:20
 * @description： 1143. 最长公共子序列
 * @modified By：
 * @version: $
 */
public class Leet1143_longestCommonSubsequence {


    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        //dp[][] 表示 A 前 i 个字符 和 B 前 j 个字符 的 最长公共子序列

        //dp[i][j] =
        // 一 ： A[i] == B[j]  dp[i][j] = dp[i-1][j-1] + 1
        // 二：  A[i] != B[j]  dp[i][j] =  Math.max(dp[i-1][j], dp[i][j-1])

        for(int i = 1; i <= m ; i++){
            for(int j = 1; j <= n; j++){

                if (text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] =  Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
        }
        return dp[m][n];
    }



    public int longestCommonSubsequence_old(String text1, String text2) {
        if (text1 == null || text2 == null){
            return 0;
        }
        int len1 = text1.length();
        int len2 = text2.length();
        //dp

        //dp[i][j] 表示 A[0---i] 和 序列 B[0---j] 的最长子序列长度
        // 看 A[i] 和 B[j] 是否相等
        //不相等
        //dp[i][j] = max(dp[i - 1][j] , dp[i][j - 1])
        // 相等的话
        // dp[i][j] = max(dp[i - 1][j] , dp[i][j - 1], dp[i-1][j - 1] + 1)
        int[][] dp = new int[len1 + 1][len2 + 1];

        for(int i = 1; i<= len1; i++){
            for(int j = 1; j <= len2; j ++){
                dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);

                if (text1.charAt(i - 1)== text2.charAt(j - 1)){
                    dp[i][j] =Math.max(dp[i][j], dp[i-1][j - 1] + 1) ;
                }
            }
        }
        return dp[len1][len2];

    }
}
