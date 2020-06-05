package com.xiong.LeetCode.JianZhiOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/2 8:54
 * @description：   面试题60. n个骰子的点数  DP 问题
 * @modified By：
 * @version: $
 */
public class J60_twoSum {

    public double[] twoSum(int n) {

        // 像这种 一轮一轮的DP 问题
        // 如果 状态转移只与 上一轮有关  则可以优化为 一维 dp

        // 表示 第 i 个骰子扔完之后， 点数 j 出现的个数
        int[][] dp = new int[n + 1][6*n + 1];
        //init
        for(int i = 1; i <= 6; i++){
            dp[1][i] = 1; // 第一个骰子扔完之后，所有点数出现的次数都是1
        }

        //枚举所有的 骰子
        for(int i = 2; i <= n; i++){
            //枚举当骰子个数为 i 时 所有可能出现的 点数
            for(int j = i; j <= 6*i; j++){
                //枚举当前 骰子 可能出现的 点数
                for(int k = 1; k <= 6; k++){
                    if (j > k){// 保证下标为正
                        dp[i][j] += dp[i - 1][j - k]; // 扔完 前i个骰子后，和为 j 出现的次数
                        // 为 扔完前 i - 1 个骰子 的情况转移而来；
                        // 即 当 第 i 个骰子 扔出 k 时， 就得得到 上一轮 j -k 出现的次数
                        // 最后把 这6种情况加起来  即为这一轮的结果
                    }

                }
            }
        }

        // 计算概率
        int len = 6 * n - n + 1;
        double total = Math.pow(6, n);
        double[] ans = new double[len];

        for(int i = 0; i < len; i++){
            ans[i] = dp[n][i + n] / total;
        }

        return ans;
    }
}
