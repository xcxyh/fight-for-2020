package com.xiong.LeetCode.DynamicProgramming;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/6 12:19
 * @description： 63. 不同路径 II
 * @modified By：
 * @version: $
 */
public class Leet63_uniquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        //init
        for(int i = 0; i < n; i++){
            if (grid[0][i] == 1){
                break;
            }
            dp[0][i] = 1;
        }
        for(int i = 0; i < m; i++){
            if (grid[i][0] == 1){
                break;
            }
            dp[i][0] = 1;
        }

        for(int i = 1; i< m; i++){
            for(int j = 1; j < n; j ++){
                // 障碍物
                if (grid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }


}
