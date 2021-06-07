package com.xiong.LeetCode.HARD;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/4/29 10:39
 * @description： 403. 青蛙过河   boolean[][]  dp[i][k] 表示 是否能 从上一个位置跳 距离 k 到 i 位置
 * 遍历 从 0 到 i 的所有 位置 j  ，k = stones[i] - stones[j]; dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
 * @modified By：
 * @version: $
 */
public class Leet403_canCross {

    public boolean canCross(int[] stones) {

        int n = stones.length;

        boolean[][] dp = new boolean[n][n];

        dp[0][0] = true;

        // 优化1
        for (int i = 1; i < n; i++) {
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }

        for (int i = 1; i < n; i++) {
            // 倒序
            for (int j = i - 1; j >=0; j--) {

                int k = stones[i] - stones[j];

                // 优化2  跳过该轮， 由于是倒序，最近的都不可能跳到 i  其他更不可能
                if (k > j + 1) {
                    break;
                }

                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];

                if (dp[n - 1][k]) {
                    return true;
                }
            }
        }
        return false;
    }
}
