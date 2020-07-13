package com.xiong.LeetCode.JianZhiOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/7 8:42
 * @description： 剑指 Offer 03. 数组中重复的数字    下标 和 元素大小 对应
 * @modified By：
 * @version: $
 */
public class J03_findRepeatNumber {
    //即下标 和 元素大小 对应
    public int findRepeatNumber(int[] nums) {
        //原地 hash
        //即下标 和 元素大小 对应

        for(int i = 0; i < nums.length; i++){
            while (nums[i] != nums[nums[i]]){
                swap(nums, i, nums[i]);
            }

        }
        int ans = 0;
        // 再次遍历
        for(int i = 0; i < nums.length; i ++){
            if (nums[i] != i){
                ans = nums[i];
                break;
            }
        }
        return ans;
    }

    private void swap(int[] nums, int a , int b){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
