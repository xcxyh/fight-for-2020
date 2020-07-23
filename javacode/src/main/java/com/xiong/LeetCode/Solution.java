package com.xiong.LeetCode;


import java.util.*;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/19 9:38
 * @description：
 * @modified By：
 * @version: $
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
    public static int minPathSum(int[][] grid) {

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
                grid[i][j] += temp== Integer.MAX_VALUE ? 0 : temp;
            }
        }


        return grid[m - 1][n - 1];
    }
}