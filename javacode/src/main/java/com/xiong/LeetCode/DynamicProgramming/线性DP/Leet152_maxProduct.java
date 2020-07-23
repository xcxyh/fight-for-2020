package com.xiong.LeetCode.DynamicProgramming.线性DP;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/18 9:46
 * @description： 152. 乘积最大子数组 ， 此题为 53. 最大子序和 maxSubArray 的进阶版
 * @modified By：
 * @version: $
 */
public class Leet152_maxProduct {

    //第二次做  忘记 要比较
    public int maxProduct2(int[] nums) {

        if (nums == null || nums.length == 0){
            return 0;
        }
        // 最小值乘以一个负数 变为了最大值
        //最大值 乘以一个负数 变成了最小值
        int n = nums.length;
        // 以当前元素结尾的 最小值
        int[] mindp = new int[n];
        // 以当前元素结尾的 最大值
        int[] maxdp = new int[n];
        mindp[0] = nums[0];
        maxdp[0] = nums[0];

        int max = maxdp[0];
        for(int i = 1; i < n; i++){
            if (nums[i] > 0){
                // 乘以之前的结果 或不乘之前的结果
                maxdp[i] = Math.max(nums[i], maxdp[i - 1] * nums[i]); // 要比较
                mindp[i] = Math.min(nums[i], mindp[i - 1] * nums[i]);
            }else{
                maxdp[i] = Math.max(nums[i], mindp[i - 1] * nums[i]);
                mindp[i] = Math.min(nums[i], maxdp[i - 1] * nums[i]);
            }
            max = Math.max(max, maxdp[i]);
        }

        return max;
    }


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
