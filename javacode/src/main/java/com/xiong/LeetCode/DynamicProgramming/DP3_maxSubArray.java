package com.xiong.LeetCode.DynamicProgramming;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/30 14:52
 * @description：
 * @modified By：
 * @version: $
 */
public class DP3_maxSubArray {

    public static void main(String[] args) {
        System.out.println(maxSubArray_dp(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    //真正的dp
    public static int maxSubArray_dp(int[] nums) {
        if(nums == null||nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] dp =new int[n];
        dp[0]=nums[0];
        int ans = nums[0];
        //状态dp[i]表示以nums[i]作为末尾的连续序列的最大和,一定要包含nums[i]
        for(int i = 1; i< n ; i++){
            dp[i] = Math.max(dp[i-1],0) + nums[i]; //状态转移 方程
            ans = Math.max(dp[i],ans);
        }
        return ans;
    }

    //我做的dp  与上面的 dp 数组的含义不同
    public static int maxSubArray(int[] nums) {
        if(nums == null||nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] dp =new int[n];
        dp[0]=nums[0];
        // dp[i] 表示从起点到index=i的这个段内的最大子序和。
        for(int i = 1; i< n ; i++){
            int max = nums[i];
            int temp =nums[i];
            for(int j = i-1; j >=0; j--){
                temp+=nums[j];
                max =Math.max(max,temp);
            }
            dp[i] = Math.max(dp[i-1],max);
        }
        return dp[n-1];
    }
}
