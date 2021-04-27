package com.xiong.LeetCode.ArrayProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/3/21 11:09
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet73_setZeroes {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean flagColFirst = false;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagColFirst = true;
            }

            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }


        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {

                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }

            if (flagColFirst) {
                matrix[i][0] = 0;
            }

        }
    }
}
