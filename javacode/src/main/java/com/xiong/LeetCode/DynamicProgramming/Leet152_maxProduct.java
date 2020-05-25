package com.xiong.LeetCode.DynamicProgramming;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/18 9:46
 * @description： 152. 乘积最大子数组 ， 此题为 53. 最大子序和 maxSubArray 的进阶版
 * @modified By：
 * @version: $
 */
public class Leet152_maxProduct {

    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int len = nums.length;
        // 用一个 dp 数组记录 最大值 无法解决问题 ，因为 数组中存在负数，
        // 一个负数乘上最大值 为最小值， 乘上最小值 为最大值
        //所以还需要一个 dp 数组来 记录最小值
        int[] dpMin = new int[len];
        int[] dpMax = new int[len];
        dpMin[0] = nums[0];
        dpMax[0] = nums[0];

        int ans = dpMax[0];

        for(int i = 1; i < len ; i++){
            if(nums[i] >= 0){
                dpMin[i] = Math.min(nums[i], nums[i] * dpMin[i-1]); // 包含 nums[i] 的 子数组的最小值
                dpMax[i] = Math.max(nums[i], nums[i] * dpMax[i-1]); // 同理
            }else{
                dpMin[i] = Math.min(nums[i], nums[i] * dpMax[i-1]);
                dpMax[i] = Math.max(nums[i], nums[i] * dpMin[i-1]);
            }
        }

        for(int i = 0; i < len ; i++){
            ans = Math.max(ans, dpMax[i]);
        }

        return ans;
    }
}
