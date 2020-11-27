package com.xiong.LeetCode.DynamicProgramming;

import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/10/24 10:29
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet1024_videoStitching {


    public int videoStitching(int[][] clips, int T) {
        // dp[i]  表示 覆盖 [0 , i] 区间 所需的最小数目
        int[] dp = new int[T + 1];

        Arrays.fill(dp, Integer.MAX_VALUE - 1);

        dp[0] = 0; // 0 区间置为 0

        for (int i = 1; i <= T; i++){

            for (int[] clip : clips){

                if (clip[0] < i && clip[1] >= i){
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1); // 转移方程
                }
            }
        }

        return dp[T] == Integer.MAX_VALUE - 1 ? -1 : dp[T];
    }
}
