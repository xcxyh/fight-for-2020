package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2019/12/6 20:06
 * @description： 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 * Consider the following matrix:
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * <p>
 * Given target = 5, return true.
 * Given target = 20,zuo'yi'yi return false.
 * 思路： 由于每行的最后一个数为该行最大，而该数又为他所在列最小的数，
 * 从第一行最后一个数开始判断，如果小于它，就 行减1 左移，如果大于它，就 列加一 下移
 * 依次下去，即可找到。
 * @modified By：
 * @version: $
 */
public class MatrixSerach_4 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(find(5, matrix));
    }

    public static boolean find(int target, int[][] matrix) {
        //边界检查
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        //从第一行开始 从最后一列开始
        int i = 0, j = cols - 1;

        while (i < rows && j >= 0) {
            //小于 左移
            if (target < matrix[i][j]) {
                j--;
            } else if (target > matrix[i][j]) {//大于 下移
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}
