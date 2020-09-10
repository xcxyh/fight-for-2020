package com.xiong.LeetCode.DP_memo;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/9/1 9:11
 * @description：  486. 预测赢家
 * @modified By：
 * @version: $
 */
public class Leet486_PredictTheWinner {


    Integer[][] memo; // 记忆化 dp
    public boolean PredictTheWinner(int[] nums) {


        int n = nums.length;
        memo = new Integer[n][n];
        // 先手多得的分数
        int max = get(nums, 0, n - 1);
        return max >= 0;
    }


    private int get(int[] nums, int l, int r) {

        if ( l == r){
            return nums[l];
        }
        if (memo[l][r] != null){
            return memo[l][r];
        }

        int left = nums[l] -  get(nums, l + 1, r);
        int right = nums[r] -  get(nums, l, r - 1);

        memo[l][r] = Math.max(left, right);
        return memo[l][r];

    }
}
