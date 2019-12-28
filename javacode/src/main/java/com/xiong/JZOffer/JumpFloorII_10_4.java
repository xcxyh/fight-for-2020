package com.xiong.JZOffer;

import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2019/12/14 14:09
 * @description： 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 规律：n=1 -> 1
 *       n=2 -> 2
 *       n=3 -> 4
 *       n=4 -> 8 ... 公比为2 的等比数列
 *       f(n-1) = f(n-2) + f(n-3) + ... + f(0) (1)
 *       f(n) = f(n-1) + f(n-2) + ... + f(0)   (2)
 *     (2) - (1)式得：  f(n) - f(n-1) = f(n-1) ----> f(n) = 2*f(n-1)
 *
 *  可以用动态规划
 * @modified By：
 * @version: $
 */
public class JumpFloorII_10_4 {
    public static void main(String[] args) {
        System.out.println();
    }
    /**
     *  @author: xiongcong
     *  @Date: 2019/12/14 14:20
     *  @Description: 动态规划
     */
    public int jumpFloorII(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp,1);
        for (int i = 0; i < target ; i++) {
            for (int j = 0; j < i ; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target-1];
    }
    /**
     *  @author: xiongcong
     *  @Date: 2019/12/14 14:20
     *  @Description: 等比数列
     */
    public int jumpFloorII_math(int target){
        return (int)Math.pow(2,target-1);
    }
}
