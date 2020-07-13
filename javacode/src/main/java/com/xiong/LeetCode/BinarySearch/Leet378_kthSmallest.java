package com.xiong.LeetCode.BinarySearch;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/2 14:59
 * @description：  378. 有序矩阵中第K小的元素
 * @modified By：
 * @version: $
 */
public class Leet378_kthSmallest {


    public int kthSmallest(int[][] matrix, int k) {
        //二分
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];

        while(left < right){
            int mid = left + (right - left) / 2;

            if (check(matrix, mid, k, n)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }


    // 统计小于等于 mid 这个数 的元素的个数 m
    private boolean check(int[][] matrix, int mid, int k , int n){
        // m >= k 证明 mid >= 我们要求的那个数，就在 [left, mid] 之间
        //否则 就是 [mid + 1, right] 之间
        int i = n - 1; int j = 0;
        // 从左下角找起，最快
        int ans = 0;
        while(j < n && i >= 0){
            if (matrix[i][j] <= mid){ // 这里是 <=
                j++;
                ans += i + 1;
            }else{
                i--;
            }
        }
        return ans >= k;
    }
}
