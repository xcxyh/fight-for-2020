package com.xiong.LeetCode.DynamicProgramming.线性DP;

import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/23 18:45
 * @description：213. 打家劫舍 II
 * @modified By：
 * @version: $
 */
public class Leet213_rob2 {
    // 不偷 第一个房间 的结果
    // 不偷 最后一个房间 的结果
    // 取这两个结果的最大值
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        if (n == 1){
            return nums[0];
        }

        int ans = 0;
        // 不偷 第一个房间 的结果
        // 不偷 最后一个房间 的结果
        // 取这两个结果的最大值
        int notRobFirst = myrob(Arrays.copyOfRange(nums, 1, n));
        int notRobLast = myrob(Arrays.copyOfRange(nums, 0, n - 1));
        return Math.max(notRobFirst,notRobLast);
    }

    private int myrob(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        if (n == 1){
            return nums[0];
        }
        if (n == 2){
            return Math.max(nums[0], nums[1]);
        }

        int robprepre = nums[0];
        int rbopre =  Math.max(nums[0], nums[1]);
        int ans = rbopre;

        for(int i = 2; i < n; i++){
            ans = Math.max(rbopre, robprepre + nums[i]);
            robprepre = rbopre;
            rbopre = ans;
        }
        return ans;
    }
}
