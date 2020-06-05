package com.xiong.LeetCode.MathProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/3 10:08
 * @description：   837. 新21点  dp    放弃了
 * @modified By：
 * @version: $
 */
public class Leet837_new21Game {
    public static void main(String[] args) {
        System.out.println(new21Game(21, 17, 10));
    }
    // dp[x] 表示从得分为 x 的情况开始游戏并且获胜的概率，目标是求 dp[0] 的值。

    public static double new21Game(int N, int K, int W) {
        if (K == 0) {
            return 1.0;
        }
        double[] dp = new double[K + W + 1];
        for (int i = K; i <= N && i < K + W; i++) {
            dp[i] = 1.0;
        }
        dp[K - 1] = 1.0 * Math.min(N - K + 1, W) / W;
        for (int i = K - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] - (dp[i + W + 1] - dp[i + 1]) / W;
        }
        return dp[0];
    }
}
