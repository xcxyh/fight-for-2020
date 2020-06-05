package com.xiong.LeetCode.JianZhiOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/5 16:28
 * @description： 面试题47. 礼物的最大价值
 * @modified By：
 * @version: $
 */
public class J47_maxValue {

    public int maxValue(int[][] grid) {
        if (grid ==null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        // 可以不用 额外数组 原地更改 也行
        //int[][] dp = new int[rows][cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                int temp = grid[i][j];
                if (i - 1 >= 0){
                    grid[i][j] = temp + grid[i - 1][j] ;
                }
                if (j - 1 >= 0){
                    grid[i][j] = Math.max(grid[i][j], temp + grid[i][j-1]);
                }
            }
        }

        return grid[rows -1][cols - 1];

    }
}
