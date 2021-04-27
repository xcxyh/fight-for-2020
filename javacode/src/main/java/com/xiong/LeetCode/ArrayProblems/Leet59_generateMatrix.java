package com.xiong.LeetCode.ArrayProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/3/16 10:38
 * @description：  59. 螺旋矩阵 II
 * @modified By：
 * @version: $
 */
public class Leet59_generateMatrix {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int rs = 0, re = n - 1, cs = 0, ce = n - 1;
        int k = 1;
        while (rs <= re) {
            for (int i = cs; i <= ce; i++) {
                matrix[rs][i] = k++;
            }
            for (int i = rs + 1; i <= re; i++) {
                matrix[i][ce] = k++;
            }

            if (rs != re) {
                for (int i = ce - 1; i >= cs; i--) {
                    matrix[re][i] = k++;
                }
            }
            if (cs != ce) {
                for (int i = re - 1; i > rs; i--) {
                    matrix[i][cs] = k++;
                }
            }

            rs++;
            re--;
            cs++;
            ce--;
        }

        return matrix;
    }
}
