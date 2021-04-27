package com.xiong.LeetCode.ArrayProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/2 17:55
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet74_searchMatrix {


    // 二分
    public boolean searchMatrix_binarySearch(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0;
        int r = m * n - 1;

        while (l <= r) {

            int mid = l + (r - l) /2;

            int cur = matrix[mid / n][mid % n];

            if (cur < target) {
                l = mid + 1;
            }else if (cur > target) {
                r = mid - 1;
            }else {
                return true;
            }
        }

        return false;
    }




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
