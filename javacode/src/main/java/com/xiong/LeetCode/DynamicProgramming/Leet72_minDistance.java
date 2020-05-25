package com.xiong.LeetCode.DynamicProgramming;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/6 14:13
 * @description： 72. 编辑距离
 * @modified By：
 * @version: $
 */
public class Leet72_minDistance {

    public static void main(String[] args) {
        System.out.println(minDistance("cat", "animal"));
    }

    /**
     * @author: xiongcong
     * @Date: 2020/4/6 14:46
     * @Description: 动态规划  （阅读打卡的一题）
     * ⼀般来说，处理两个字符串的动态规划问题，建立DP table，找到状态转移的关系
     *
     */
    public static int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) {
            return 0;
        }
        if (word1 == null || word1.length() == 0) {
            return word2.length();
        }
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }
        int len1 = word1.length();
        int len2 = word2.length();
        //dp[i][j] 表示 单词 A[0,i] 部分 和 单词 B[0,j] 部分 的编辑距离 (操作数)
        int[][] dp = new int[len1 + 1][len2 + 1];
        //当 Ai == Bj 时 dp[i][j] = dp[i-1][j-1]
        //当 Ai != Bj 时 dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]) + 1
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        //dp数组初始化 base case
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }


    private static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
