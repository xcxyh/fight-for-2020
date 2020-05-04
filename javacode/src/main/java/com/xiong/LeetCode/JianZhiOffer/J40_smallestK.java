package com.xiong.LeetCode.JianZhiOffer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/3 11:26
 * @description： 面试题 17.14. 最小K个数
 * @modified By：
 * @version: $
 */
public class J40_smallestK {
    public int[] smallestK(int[] arr, int k) {
        // 1排序

        quickSort(arr, 0, arr.length - 1);

        return Arrays.copyOf(arr, k);

    }
    //快排
    private void quickSort(int[] arr, int low, int high){

        if (low > high){
            return;
        }

        int i = low;
        int j = high;

        int temp = arr[low];

        while(i < j){
            // 从右向左
            while(i < j && arr[j] >= temp){
                j--;
            }

            while(i < j && arr[i] <= temp){
                i++;
            }

            if (i < j){
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        arr[low] = arr[i];
        arr[i] = temp;

        quickSort(arr, low, i - 1);
        quickSort(arr, i + 1, high);

    }

    //2 优先队列
    private int[] smallestK_priorityQueue(int[] arr, int k){
        Queue<Integer> queue = new PriorityQueue<>();
        for(int n : arr){
            queue.offer(n);
        }
        int[] ans = new int[k];
        int i = 0;
        while(i < k){
            ans[i++] = queue.poll();
        }
        return ans;
    }
}
