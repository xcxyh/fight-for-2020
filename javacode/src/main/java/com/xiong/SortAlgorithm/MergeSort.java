package com.xiong.SortAlgorithm;

import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/24 10:29
 * @description： 归并排序 时间复杂度 O(N * logN) 空间复杂度 O(n)
 * 归并排序（MERGE-SORT）是建立在归并操作上的一种有效的排序算法,
 * 该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。
 * 若将两个有序表合并成一个有序表，称为二路归并。
 * @modified By：
 * @version: $
 */
public class MergeSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSort(new int[]{4, 2, 5, 3, 1, 6})));
    }


    private static int[] temp; // 辅助数组 放在 merge 外面
    private static int[] mergeSort(int[] arr) {

        if (arr == null || arr.length <= 1) {
            return arr;
        }
        temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    //归并排序
    private static void mergeSort(int[] arr, int left, int right) {
        if (right <= left) {
            return;
        }

        int mid = left + (right - left) / 2;
        //拆分
        mergeSort(arr, left, mid);
        //拆分
        mergeSort(arr, mid + 1, right);
        //合并
        merge(arr, left, mid, right);

    }
    //合并
    private static void merge(int[] arr, int left, int mid, int right) {

        int i = left; // 左的起点
        int j = mid + 1; // 右的起点
        int k = left; // 临时数组的 起点 ！！！！ 不要设置为 0
        //合并
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {  //  <= 则 为稳定排序  如果写 严格小于 < 则不稳定
                temp[k] = arr[i];
                i++;
                k++;
            } else {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }
        // 当 左边还有剩余
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // 当 右边还有剩余
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        //从temp 到 arr
        while (left <= right) {
            arr[left] = temp[left];
            left++;
        }

    }
}
