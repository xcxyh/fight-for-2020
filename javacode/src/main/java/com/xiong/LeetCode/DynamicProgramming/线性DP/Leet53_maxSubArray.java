package com.xiong.LeetCode.DynamicProgramming.线性DP;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/30 14:52
 * @description：  53. 最大子序和
 * @modified By：
 * @version: $
 */
public class Leet53_maxSubArray {

    public static void main(String[] args) {
        System.out.println(maxSubArray_dp(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    //第三次做
    public int maxSubArray3(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        //dp[i] 表示 以 i 位置元素结尾的 连续子数组最大和
        int[] dp = new int[n];

        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1; i < n; i++){

            dp[i] = nums[i];

            if (dp[i - 1] > 0){
                dp[i] += dp[i - 1];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
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
    // 第二次做的写法
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        //dp
        int[] dp = new int[len];
        dp[0]= nums[0];
        for(int i = 1; i < len; i++){
            if (dp[i-1] > 0){// 前面的子序和大于0 时 加上
                dp[i] = dp[i-1] + nums[i];
            }else{
                dp[i] = nums[i];
            }

        }
        int ans = dp[0];
        for(int i = 0; i < len; i++){
            ans = Math.max(ans,dp[i]);
        }

        return ans;

    }
}
