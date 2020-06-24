package com.xiong.LeetCode.JianZhiOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/14 16:30
 * @description： 面试题42. 连续子数组的最大和
 * @modified By：
 * @version: $
 */
public class J42_maxSubArray {
    //第三次做
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        int ans = Integer.MIN_VALUE;
        dp[0] = nums[0];
        for(int i = 1; i < n; i++) {
            if (dp[i-1] > 0){
                dp[i] = nums[i] + dp[i-1];
            }else
            {
                dp[i] = nums[i];
            }
        }
        for(int x : dp){
            ans = Math.max(ans, x);
        }
        return ans;
    }
}
