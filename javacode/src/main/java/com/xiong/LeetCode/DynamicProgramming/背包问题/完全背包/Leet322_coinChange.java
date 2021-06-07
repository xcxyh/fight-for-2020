package com.xiong.LeetCode.DynamicProgramming.背包问题.完全背包;

import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/3 10:18
 * @description： 322. 零钱兑换  与  Leet08_11_waysToChangeCoin 面试题 08.11. 硬币 不同
 * @modified By：
 * @version: $
 */
public class Leet322_coinChange {
    public static void main(String[] args) {
        System.out.println(new Leet322_coinChange().coinChange(new int[]{1, 2, 5}, 11));
    }

    // 完全背包
    public int coinChange_dp(int[] coins, int amount) {
        //dp
        //dp[i] 凑成 i 的最小硬币数

        //dp[i]
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);
        dp[0] = 0; // base case !
        for(int i = 0; i <= amount; i++){
            for(int coin : coins){

                if (i < coin){
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] ==  amount + 1 ? -1 : dp[amount];
    }


    private int[] coins;
    private Integer[] memo;
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        memo = new Integer[amount + 1];
        return dp(amount);
    }
    // dp(n) 表示 凑出 n 所需的最小硬币数  dp函数 + memo 备忘录 的形式
    private int dp(int n){
        if (n == 0){
            return 0;
        }
        if (n < 0){
            return -1;
        }
        if (memo[n] != null){
            return memo[n];
        }

        int res = Integer.MAX_VALUE;
        for(int c : coins){
            int subproblem = dp(n - c);
            if (subproblem < 0){ // 无解
                continue;
            }
            res = Math.min(res, 1 + subproblem);
        }

        memo[n] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[n];
    }

}
