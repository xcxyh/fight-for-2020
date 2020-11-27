package com.xiong.LeetCode.ArrayProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/11/14 10:03
 * @description： 1122. 数组的相对排序
 * @modified By：
 * @version: $
 */
public class Leet1122_relativeSortArray {


    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0){
            return arr1;
        }

        int[] bucket = new int[1001];

        for (int x : arr1) {
            bucket[x]++;
        }
        int k = 0;
        for (int x : arr2){
            int count = bucket[x];
            while(count-- > 0){
                arr1[k++] = x;
            }
            bucket[x] = 0;
        }

        for (int i = 0; i < 1001; i++){
            int count = bucket[i];
            while(count-- > 0){
                arr1[k++] = i;
            }
        }
        return arr1;
    }

}
