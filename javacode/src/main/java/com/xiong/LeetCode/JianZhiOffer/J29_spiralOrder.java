package com.xiong.LeetCode.JianZhiOffer;

import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/5 10:02
 * @description： 面试题29. 顺时针打印矩阵
 * @modified By：
 * @version: $
 */
public class J29_spiralOrder {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new J29_spiralOrder().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new int[]{};
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] ans = new int[rows * cols];

        int row_start = 0, row_end = rows - 1;
        int col_start = 0, col_end = cols - 1;
        int k = 0;
        // 角标越界问题 很烦
        while(row_start <= row_end && col_start <= col_end){
            // 向右  123   5
            for (int i = col_start; i <= col_end; i++) {
                ans[k++] = matrix[row_start][i];
            }

            //向下  69
            for (int i = row_start + 1; i <= row_end ; i++) {
                ans[k++] = matrix[i][col_end];
            }

            //向左 ，先判断 行是否相遇  87
            if (row_start != row_end){
                for (int i = col_end - 1; i >= col_start ; i--) {
                    ans[k++] = matrix[row_end][i];
                }
            }

            //向上,  先判断 列是否相遇  4
            if (col_start != col_end) {
                for (int i = row_end - 1; i > row_start; i--) {
                    ans[k++] = matrix[i][col_start];
                }
            }

            row_start++;
            col_start++;
            row_end--;
            col_end--;
        }

        return ans;
    }
}
