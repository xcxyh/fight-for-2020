package com.xiong.LeetCode.ArrayProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/2 17:50
 * @description： 240. 搜索二维矩阵 II
 * @modified By：
 * @version: $
 */
public class Leet240_searchMatrix {


    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int row = m - 1;
        int col = 0;

        while(col <n && row >= 0 ){
            int temp = matrix[row][col];
            if (temp > target){
                row--;
            }else if (temp < target){
                col++;
            }else{
                return true;
            }
        }
        return false;
    }
}
