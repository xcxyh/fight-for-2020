package com.xiong.JZOffer;

import java.util.ArrayList;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/10 17:55
 * @description： 最小的K个数  使用快排 或者 大顶堆
 * @modified By：
 * @version: $
 */
public class J40_GetLeastNumbers {

    public static void main(String[] args) {
        ArrayList<Integer> asn =  GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8}, 4);
        System.out.println(asn);
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (input == null || input.length == 0){
            return ans;
        }
        if(k > input.length){
            return ans;
        }
        //快排
        quickSort(input, 0, input.length - 1);
        for(int i = 0; i<k; i++){
            ans.add(input[i]);
        }
        return ans;
    }

    private static void quickSort(int[] arr, int low, int high){
        if (low > high){
            return;
        }

        int temp = arr[low];//基准
        int i = low;
        int j = high;
        while(i < j){
            // 从右向左找  小于 temp (必须先 从右向左找，因为最开始的基准位在 low 位置)
            while(i < j && arr[j] >= temp){
                j--;
            }

            while(i < j && arr[i] <= temp){
                i++;
            }

            if(i < j){
                swap(arr,i, j);
            }
        }

        arr[low] = arr[i];
        arr[i] = temp;

        quickSort(arr,low, i - 1);
        quickSort(arr,i + 1 , high);

    }
    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
