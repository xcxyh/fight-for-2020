package com.xiong.LeetCode.ArrayProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/5 17:13
 * @description： 48. 旋转图像
 * @modified By：
 * @version: $
 */
public class Leet48_rotate {

    public void rotate(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int n = matrix.length;

        // 1 沿 正对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }

        // 2 沿 竖中线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = t;
            }
        }


    }
}
