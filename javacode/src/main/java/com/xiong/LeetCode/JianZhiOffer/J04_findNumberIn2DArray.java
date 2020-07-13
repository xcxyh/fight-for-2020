package com.xiong.LeetCode.JianZhiOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/7 8:48
 * @description：  剑指 Offer 04. 二维数组中的查找
 * @modified By：
 * @version: $
 */
public class J04_findNumberIn2DArray  {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }

        // 从 左下角找起

        int rows = matrix.length;
        int cols = matrix[0].length;

        int i = rows - 1;
        int j = 0;

        while( j < cols && i >= 0){

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
