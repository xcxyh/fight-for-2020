package com.xiong.LeetCode.StringsProblem;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/21 9:27
 * @description： 516 最长回文子序列    dp[][]
 * @modified By：
 * @version: $
 */
public class Leet516_longestPalindromeSubseq {

    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        //dp
        //dp[i][j] 表示 从 i 到 j 的 最长回文子序列 的长度
        int len = s.length();
        int[][] dp = new int[len][len];
        //init
        for(int i = 0; i < len; i++){
            dp[i][i] = 1;
        }
        // dp[i][j] = dp[i + 1][j - 1] + 2
        // else  dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]);
        // 反着遍历保证正确的状态转移
        for(int i = len - 1; i >= 0; i--){
            for(int j = i + 1; j < len; j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }

        }

        return dp[0][len-1];


    }

}
