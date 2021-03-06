package com.xiong.LeetCode.DailyProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/3/2 10:45
 * @description：   304. 二维区域和检索 - 矩阵不可变   二维前缀和
 * @modified By：
 * @version: $
 */
public class Leet304_NumMatrix {

    /**
     * Your NumMatrix object will be instantiated and called as such:
     * NumMatrix obj = new NumMatrix(matrix);
     * int param_1 = obj.sumRegion(row1,col1,row2,col2);
     */

    private int[][] sumMatrix;
    public Leet304_NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m > 0) {
            int n = matrix[0].length;

            sumMatrix = new int[m + 1][n + 1];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    sumMatrix[i][j] = sumMatrix[i - 1][j] + sumMatrix[i][j - 1]
                            - sumMatrix[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        return sumMatrix[row2 + 1][col2 + 1]
                - sumMatrix[row1][col2 + 1] - sumMatrix[row2 + 1][col1]
                + sumMatrix[row1][col1];
    }
}
