package com.xiong.SortAlgorithm;

import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/20 14:59
 * @description：
 * @modified By：
 * @version: $
 */
public class QuickSort {
    public static void main(String[] args) {

        int[] arr = new int[]{9,6,8,4,7,2,3,1};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    /**
     * @author: xiongcong
     * @Date: 2020/3/20 14:59
     * @Description: 递归实现快排
     */
    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[low];

        while (i < j) {
            //先看右边，依次往左递减 找小于基准值的 或者 i == j
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增 找大于基准值的 或者 i == j
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }
}
