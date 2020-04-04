package com.xiong.SortAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/20 14:59
 * @description：
 * @modified By：
 * @version: $
 */
public class QuickSort {
    public static void main(String[] args) {

        int[] arr = new int[]{5,1,1,2,0,0};
        quickSort(arr, 0, arr.length-1);
        Arrays.sort(arr);  // 底层 为 双轴快排 DualPivotQuicksort
        Collections.sort(new ArrayList<Integer>()); //底层 有  TimSort
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
            //先看右边，依次往左递减 找小于基准值的 或者 i == j  （这两个while 顺序不能反）
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
        quickSort(arr, low,  i - 1);
        //递归调用右半数组
        quickSort(arr,  i + 1, high);
    }
    /**
     *  @author: xiongcong
     *  @Date: 2020/3/31 10:03
     *  @Description:   简洁形式  快排
     */
    private void qSort(int[] arr,int s,int e){
        int l = s, r = e;
        if(l < r){
            int temp = arr[l];
            while(l < r){
                while(l < r && arr[r] >= temp) r--;
                if(l < r) arr[l] = arr[r];
                while(l < r && arr[l] < temp) l++;
                if(l < r) arr[r] = arr[l];
            }
            arr[l] = temp;
            qSort(arr,s,l);
            qSort(arr,l + 1, e);
        }
    }

}
