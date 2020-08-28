package com.xiong.AForkTheWork.DiDi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/22 12:18
 * @description：
 * @modified By：
 * @version: $
 */
public class Exams {
    // 1
    private static void solve(int n) {

        int count = 0;
        List<int[]> ans = new ArrayList<>();
        // abc + acc = n
        for (int a = 1; a <= 9; a++) {
            for (int b = 0; b <= 9; b++) {
                for (int c = 0; c <= 9; c++) {
                    if (a != b && b != c && a != c) {
                        int num1 = getNum(a, b, c);
                        int num2 = getNum(a, c, c);
                        if (num1 + num2 == n) {
                            ans.add(new int[]{num1, num2});
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
        for (int[] arr : ans) {
            System.out.println(arr[0] + " " + arr[1]);
        }
    }

    private static int getNum(int a, int b, int c) {
        return a * 100 + b * 10 + c;
    }

    // 2 斐波拉契 + 顺时针打印矩阵
    private static void printMatrix(int n) {

        if (n == 0) {
            System.out.println();
            return;
        }
        if (n == 1) {
            System.out.println(1);
            return;
        }
        // 要转成 long 长整型
        long[] arr = new long[n * n];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i < n * n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        long[][] matrix = change(arr, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == n - 1) {
                    System.out.print(matrix[i][j]);
                } else {
                    System.out.print(matrix[i][j] + " ");
                }

            }
            System.out.println();
        }

    }

    public static long[][] change(long[] arr, int n) {

        long[][] matrix = new long[n][n];


        int row_start = 0, row_end = n - 1;
        int col_start = 0, col_end = n - 1;

        int k = n * n - 1;

        while (row_start <= row_end && col_start <= col_end) {
            // 向右
            for (int i = col_start; i <= col_end; i++) {
                matrix[row_start][i] = arr[k--];
            }

            //向下
            for (int i = row_start + 1; i <= row_end; i++) {
                matrix[i][col_end] = arr[k--];
            }
            //向左 ，先判断 行是否相遇
            if (row_start != row_end) {
                for (int i = col_end - 1; i >= col_start; i--) {
                    matrix[row_end][i] = arr[k--];
                }
            }

            //向上,  先判断 列是否相遇
            if (col_start != col_end) {
                for (int i = row_end - 1; i > row_start; i--) {
                    matrix[i][col_start] = arr[k--];
                }
            }

            row_start++;
            col_start++;
            row_end--;
            col_end--;
        }

        return matrix;
    }

    private static int gcd(int a, int b) {
        // 默认a >= b
        return b == 0 ? a : gcd(b, a % b);
    }

}
