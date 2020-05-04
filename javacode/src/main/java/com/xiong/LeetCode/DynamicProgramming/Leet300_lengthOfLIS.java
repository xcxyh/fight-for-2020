package com.xiong.LeetCode.DynamicProgramming;

import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/30 18:20
 * @description： 300. 最长上升子序列  这是一道非常重要的题目
 * @modified By：
 * @version: $
 */
public class Leet300_lengthOfLIS {

    //O(n^2) 复杂度  可以通过 二分查找来优化
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        //dp
        //dp[i] 表示 包含nums[i] 的 从 0 到 i 的最长上升子序列的长度 （不必连续）
        // 要将 从 0 到 i 的所有元素和当前 nums[i] 相比，
        // 如果 nums[j] < nums[i] 就 dp[j] + 1
        // 取这些结果里面最大的即为 dp[i]
        int len = nums.length;
        int[] dp = new int[len];
        //全部初始化为1
        Arrays.fill(dp, 1);
        for(int i = 1; i < len; i++){
            for(int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    dp[i] =Math.max(dp[i], dp[j] + 1) ;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < len; i++){
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
