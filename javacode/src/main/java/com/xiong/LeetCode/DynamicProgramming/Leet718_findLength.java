package com.xiong.LeetCode.DynamicProgramming;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/1 12:16
 * @description： 718. 最长重复子数组
 * @modified By：
 * @version: $
 */
public class Leet718_findLength {


    public int findLength(int[] A, int[] B) {

        int m = A.length;
        int n = B.length;
        // A 中 以 i 结尾 和 B 中 以 j 结尾 的 公共的、长度最长的子数组的长度。
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;

        //init
        int ans = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if (A[i - 1] == B[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = 0;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
