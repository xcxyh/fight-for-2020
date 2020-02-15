package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/14 14:30
 * @description： 礼物的最大价值 动态规划 求解
 * 在一个 m*n 的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于 0）。
 * 从左上角开始拿礼物，每次向右或向下移动一格，直到右下角结束。
 * 给定一个棋盘，求拿到礼物的最大价值。例如，对于如下棋盘
 * <p>
 * 1    10   3    8
 * 12   2    9    6
 * 5    7    4    11
 * 3    7    16   5
 * 礼物的最大价值为 1+12+5+7+7+16+5=53。
 * @modified By：
 * @version: $
 */
public class J47_DynamicProgram {

    public static void main(String[] args) {
        int[][] values = new int[][]{
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}
        };
        System.out.println(new J47_DynamicProgram().getMost2(values));
    }

    public int getMost(int[][] values) {

        if (values == null || values.length == 0) {
            return 0;
        }

        int rows = values.length;
        int cols = values[0].length;
        int[] dp = new int[cols]; //也可以新建一个二维数组
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int up = 0;
                int left = 0;
                if (i > 0) {
                    up = dp[j];
                }
                if (j > 0) {
                    left = dp[j - 1];
                }
                dp[j] = Math.max(up, left) + values[i][j];
            }
        }
        return dp[cols - 1];
    }

    public int getMost2(int[][] values) {
        if (values == null || values.length == 0) {
            return 0;
        }
        int rows = values.length;
        int cols = values[0].length;
        int[][] dp = new int[rows][cols]; //新建一个二维数组
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int up = 0;
                int left = 0;
                if (i > 0) {
                    up = dp[i - 1][j];
                }
                if (j > 0) {
                    left = dp[i][j - 1];
                }
                dp[i][j] = Math.max(up, left) + values[i][j];
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
