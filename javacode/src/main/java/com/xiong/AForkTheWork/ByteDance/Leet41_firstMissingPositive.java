package com.xiong.AForkTheWork.ByteDance;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/27 12:28
 * @description：  面经中的， 41. 缺失的第一个正数   原地hash 法，  将 大小为 x 的元素 放置在 下标为 x - 1 的位置上
 * @modified By：
 * @version: $
 */
public class Leet41_firstMissingPositive {

    //原地hash ---> 位图法
    // 原地hash 法，  将 大小为 x 的元素 放置在 下标为 x - 1 的位置上
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0){
            return 1;
        }
        int n = nums.length;

        for(int i = 0; i < n; i++){
            while(nums[i]>= 1 && nums[i] < n && nums[i] != nums[nums[i] - 1] ){
                swap(nums, i , nums[i] - 1);
            }
        }

        // 找出那个 nums[i] != i + 1 的元素
        for(int i = 0; i < n; i++){
            if (nums[i] != i + 1){
                return i + 1;
            }
        }
        return n + 1;
    }
    private void swap(int[] arr, int a, int b){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    // hashSet 法，不符合要求
    public int firstMissingPositive_set(int[] nums) {
        if (nums == null || nums.length == 0){
            return 1;
        }

        Set<Integer> set = new HashSet<>();
        for(int x : nums){
            if (x > 0){
                set.add(x);
            }
        }

        for(int i = 1; ; i++){
            if (!set.contains(i)){
                return i;
            }
        }
    }
}
