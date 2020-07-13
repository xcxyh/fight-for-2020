package com.xiong.LeetCode.ArrayProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/2 17:55
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet79_searchMatrix {


    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0|| matrix[0].length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = m - 1;
        int j = 0;

        while(i >=0 && j < n){
            if (matrix[i][j] > target){
                i--;
            }else if (matrix[i][j] < target){
                j++;
            }else{
                return true;
            }
        }
        return false;
    }
}
