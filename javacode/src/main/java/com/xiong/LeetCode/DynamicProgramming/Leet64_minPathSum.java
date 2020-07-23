package com.xiong.LeetCode.DynamicProgramming;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/23 8:46
 * @description： 64. 最小路径和
 * @modified By：
 * @version: $
 */
public class Leet64_minPathSum {

    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;


        for(int i = 0; i< m; i++){
            for(int j = 0; j < n; j ++){
                int temp = Integer.MAX_VALUE;
                if (i > 0){
                    temp =  grid[i - 1][j];
                }
                if (j > 0){
                    temp = Math.min(temp, grid[i][j - 1]);
                }
                grid[i][j] += temp == Integer.MAX_VALUE ? 0 : temp;
            }
        }
        return grid[m - 1][n - 1];
    }
}
