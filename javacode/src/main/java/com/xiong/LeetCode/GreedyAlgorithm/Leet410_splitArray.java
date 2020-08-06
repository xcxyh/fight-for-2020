package com.xiong.LeetCode.GreedyAlgorithm;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/28 12:39
 * @description： 410. 分割数组的最大值   最大化最小值 问题   贪心
 * @modified By：
 * @version: $
 */
public class Leet410_splitArray {

    // 贪心 ， 子数组各自和的最大值  介于  left  和 right 之间
    // 那么，只要找到一个 值 能把 该数组分为 m 个 子数组，
    // 此时  子数组各自和的最大值 最小
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int n = nums.length;
        //贪心

        int left = 0;
        int right = 0;
        for(int x : nums){
            left = Math.max(left, x);
            right += x;
        }

        while(left < right){
            int mid = left + (right - left) / 2;

            int splitNum = 1; // 至少 一个 子数组 就是他本身
            int sumMax = 0;
            for(int x : nums){
                if (sumMax + x > mid){
                    sumMax = 0;
                    splitNum++;
                }
                sumMax += x;
            }
            //分割出来的 子数组个数 大于m  证明 当前 mid 小于目标值
            // 增大 mid  就能 减小 splitNum
            if (splitNum > m){
                left = mid + 1;
            }else{ // 反之
                right = mid;
            }

        }
        return left;
    }



    // dp
    public int splitArray_dp(int[] nums, int m) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        //res = min(res, max(第 i种分割方法 的所有子数组的和));

        //dp[i][j]表示将数组的前 i 个数分割为 j 段所能得到的最大连续子数组和的最小值。
        int n = nums.length;

        int[][] dp = new int[n + 1][m + 1];

        //init
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <=m; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        // 计算前缀和
        int[] sub = new int[n + 1];
        for(int i = 0; i < n; i++){
            sub[i + 1] = sub[i] + nums[i];
        }

        dp[0][0] = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <=m; j ++){
                // 从 i 种 分割方案 中 找最小值
                for(int k = 0; k < i; k ++){
                    // 第 k 种 分割方案的 子数组各自和 的最大值
                    int sumMax = Math.max(dp[k][j - 1], sub[i] - sub[k]);
                    // 求这 些分割方案 子数组各自和的最大值  的最小值
                    dp[i][j] = Math.min(dp[i][j], sumMax);
                }
            }
        }
        return dp[n][m];

    }
}
