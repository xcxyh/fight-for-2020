package com.xiong.LeetCode.DynamicProgramming;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/8 10:17
 * @description： 221. 最大正方形  dp[][] 求解
 * @modified By：
 * @version: $
 */
public class Leet221_maximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];
        //dp[i][j] 表示 以 (i,j) 作为右下角的正方形的 最大边长
        // matrix[i][j] = 1 时
        //dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1

        //dp 初始化
        int ans = 0;
        for(int i = 0; i < rows; i++){
            dp[i][0] = matrix[i][0] - '0';
            ans = Math.max(ans, dp[i][0]);
        }
        for(int j = 0; j < cols; j++){
            dp[0][j] = matrix[0][j] - '0';
            ans = Math.max(ans, dp[0][j]);
        }

        for(int i = 1; i < rows; i++){
            for(int j = 1; j < cols; j++){
                if (matrix[i][j] == '1'){
                    dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1;
                }else{
                    dp[i][j] = 0;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans*ans;
    }

    private int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
}
