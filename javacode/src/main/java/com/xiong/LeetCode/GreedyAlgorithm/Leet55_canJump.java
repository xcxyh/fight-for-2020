package com.xiong.LeetCode.GreedyAlgorithm;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/17 12:13
 * @description：  55. 跳跃游戏
 * @modified By：
 * @version: $
 */
public class Leet55_canJump {
    /**
     *  @author: xiongcong
     *  @Date: 2020/4/17 12:14
     *  @Description:  太简洁了    贪心算法
     */ 
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1){
            return true;
        }
        int len = nums.length;
        int max = 0;
        for(int i = 0; i< len ; i++){
            if(max < i){ // 现有的最大位置小于 i  证明 i 位置不可达  返回false
                return false;
            }
            max = Math.max(max, i+nums[i] ); //记录能跳到的最大位置
        }
        return true;
    }

    private boolean canJump_dp(int[] nums){
        if (nums == null || nums.length <= 1){
            return true;
        }
        int len = nums.length;

        boolean[] dp = new boolean[len];// 表示是否可达
        // dp[i] = dp[0]&& nums[0]>= i || dp[1]&& nums[1]>= i - 1 ...
        dp[0] = true;
        for(int i = 1; i < len; i++){
            for(int j = 0 ; j < i ; j++){
                dp[i] = dp[i] || (dp[j] && nums[j] >= i - j);
            }
        }
        return dp[len -1];
    }
}
