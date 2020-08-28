package com.xiong.LeetCode.ArrayProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/27 18:20
 * @description：  977. 有序数组的平方
 * @modified By：
 * @version: $
 */
public class Leet977_sortedSquares {


    public int[] sortedSquares(int[] A) {

        if (A == null || A.length == 0){
            return A;
        }

        int n = A.length;

        int midIndex = 0;

        for(int i = 0; i < n; i++){
            if (A[i] >= 0) {
                midIndex = i;
                break;
            }
        }

        for(int i = 0; i < n; i++){
            A[i] = A[i] * A[i];
        }

        int[] arr = new int[n];

        int i = midIndex-1;
        int j = midIndex;
        int k = 0;
        while(i >= 0 && j < n){
            if (A[i] > A[j]){
                arr[k++] = A[j];
                j++;
            }else{
                arr[k++] = A[i];
                i--;
            }
        }
        while(i >= 0){
            arr[k++] = A[i--];
        }
        while(j < n){
            arr[k++] = A[j++];
        }
        return arr;
    }
}
