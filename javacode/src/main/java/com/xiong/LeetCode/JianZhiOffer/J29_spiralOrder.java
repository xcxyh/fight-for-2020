package com.xiong.LeetCode.JianZhiOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/5 10:02
 * @description： 面试题29. 顺时针打印矩阵
 * @modified By：
 * @version: $
 */
public class J29_spiralOrder {


    public static void main(String[] args) {

    }

    public List<Integer> spiralOrder(int[][] matrix) {


        List<Integer> ans = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return ans;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int rs = 0, re = rows -1, cs = 0, ce = cols - 1;

        while (rs <= re && cs <= ce) {

            // right
            for(int i = cs; i <= ce; i++){
                ans.add(matrix[rs][i]);
            }
            // down
            for(int i = rs + 1; i <= re; i++){
                ans.add(matrix[i][ce]);
            }
            // left
            if (rs != re) {
                for (int i = ce - 1; i >= cs; i--) {
                    ans.add(matrix[re][i]);
                }
            }
            // up
            if (cs != ce) {
                // 因为第一行已经打印过了 这里 i 不要再等于 rs 了
                for (int i = re - 1; i > rs; i--) {
                    ans.add(matrix[i][cs]);
                }
            }

            cs++;
            rs++;
            ce--;
            re--;

        }

        return ans;

    }


    public static int[] spiralOrder2(int[][] matrix) {
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
                // 因为第一行已经打印过了 这里 i 不要再等于 row_start 了
                for (int i = row_end - 1; i > row_start; i--) { //   i > row_start 这里不等 ！！
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
