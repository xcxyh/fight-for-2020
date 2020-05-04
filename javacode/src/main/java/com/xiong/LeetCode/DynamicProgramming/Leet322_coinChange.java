package com.xiong.LeetCode.DynamicProgramming;

import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/3 10:18
 * @description： 322. 零钱兑换  与  Leet08_11_waysToChangeCoin 面试题 08.11. 硬币 不同
 * @modified By：
 * @version: $
 */
public class Leet322_coinChange {

    public int coinChange(int[] coins, int amount) {
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

}
