package com.xiong.LeetCode.DynamicProgramming;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/23 12:35
 * @description：  面试题 08.11. 硬币  完全背包问题的相似问题
 * @modified By：
 * @version: $
 */
public class Leet08_11_waysToChangeCoin {

    public static void main(String[] args) {
        System.out.println(waysToChange_3(900750));
    }

    // 转化为完全背包问题，  朴素解法1  会超时  O(n^3)  O(n)
    public static int waysToChange_1(int n) {
        int mod = 1000000007;
        //dp[][] 表示 前 i 种面值 构成 面值 j 的方案数
        int[][] dp = new int[5][n + 1];
        int[] m = new int[]{1, 5, 10, 25};
        //
        dp[0][0] =1;
        //dp[i][j] = dp[i - 1][j] + dp[i - 1][j- m[i]] + dp[i - 1][j- 2 * m[i]] ....
        for (int i = 1; i <= 4; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; j >= k * m[i-1]; k++) {
                    dp[i][j] += dp[i - 1][j - k * m[i-1]];
                }
            }
        }
        return dp[4][n] % mod;
    }

    // 时间上优化  O(n^2)  O(n)
    public static int waysToChange_2(int n) {
        int mod = 1000000007;
        //dp[][] 表示 前 i 种面值 构成 面值 j 的方案数
        int[][] dp = new int[5][n + 1];
        int[] m = new int[]{1, 5, 10, 25};
        //初始化
        for(int i = 0; i<= 4 ; i++){
            dp[i][0] = 1;
        }
        //dp[i][j] = dp[i - 1][j] + dp[i - 1][j- m[i]] + dp[i - 1][j- 2 * m[i]] ....
        for (int i = 1; i <= 4; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= m[i-1]){
                    //注意是 dp[i][ j - m[i-1] ] 这个是推导得到的
                    dp[i][j] += dp[i][j-m[i-1]] % mod; // 这里防止溢出！！
                }
            }
        }
        return dp[4][n] % mod;
    }

    //空间上优化  最终版本  O(n^2)  O(1)
    public static int waysToChange_3(int n) {
        int mod = 1000000007;
        //dp[][] 表示 前 i 种面值 构成 面值 j 的方案数
        int[] dp = new int[n + 1];
        int[] m = new int[]{1, 5, 10, 25};
        //初始化
        dp[0] = 1;
        for (int i = 1; i <= 4; i++) {
            for (int j = 0; j <= n; j++) {
                if (j >= m[i-1]){
                    dp[j] += dp[j-m[i-1]] % mod; // 这里防止溢出！！
                }
            }
        }
        return dp[n] % mod;
    }
}
