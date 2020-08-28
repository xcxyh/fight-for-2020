package com.xiong.SortAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/11 12:31
 * @description： 969. 煎饼排序
 * @modified By：
 * @version: $
 */
public class Leet969_pancakeSort {

    private List<Integer> ans = new ArrayList<>();
    public List<Integer> pancakeSort(int[] arr) {
        if (arr == null || arr.length < 2){
            return ans;
        }

        pancakeSort(arr, arr.length);
        return ans;
    }
    // 排序前 k 个元素,  k 从 1 开始
    private void pancakeSort(int[] arr, int k){

        if (k == 1){
            return;
        }

        int max = arr[0];
        int maxIndex = 0;

        for (int i = 1; i < k; i++) {
            if (arr[i] > max){
                max = arr[i];
                maxIndex = i;
            }
        }

        // 将当前最大的 翻转到 头部
        reverse(arr, maxIndex);
        // add
        ans.add(maxIndex + 1);
        // 再将头部翻转到尾部
        reverse(arr, k - 1);
        // add
        ans.add(k);
        // 递归求解剩余的
        pancakeSort(arr, k - 1);

    }

    // 翻转[0, endIndex] 之间的元素
    private void reverse(int[] arr, int endIndex){
        int i  = 0;
        int j = endIndex;
        while(i < j){
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
    }
}
