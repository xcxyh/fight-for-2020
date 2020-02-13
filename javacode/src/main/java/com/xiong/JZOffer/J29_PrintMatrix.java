package com.xiong.JZOffer;

import java.util.ArrayList;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/8 17:04
 * @description： 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * <p>
 * 例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @modified By：
 * @version: $
 */
public class J29_PrintMatrix {
    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println(printMatrix(matrix));
    }
    /**
     *  @author: xiongcong
     *  @Date: 2020/2/9 15:32
     *  @Description:  解法固定 ， 以四个标志，开始向内遍历
     */
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int r1 = 0, c1 = 0, r2 = rows - 1, c2 = cols - 1; // 四个index
        while (r1 <= r2 && c1 <= c2) {
            //向右
            for (int i = c1; i <= c2; i++) {
                result.add(matrix[r1][i]);
            }
            //向下
            for (int i = r1 + 1; i <= r2; i++) {
                result.add(matrix[i][c2]);
            }
            //向左时，先判断 行是否相遇
            if (r1 != r2) {
                for (int i = c2 - 1; i >= c1; i--) {
                    result.add(matrix[r2][i]);
                }
            }
            //向上，先判断 列是否相遇
            if (c1 != c2) {
                for (int i = r2 - 1; i > r1; i--) {
                    result.add(matrix[i][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;

        }
        return result;
    }

}
