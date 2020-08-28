package com.xiong.LeetCode.DynamicProgramming;

import java.util.Scanner;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/19 18:34
 * @description：   AcWing02   01 背包问题
 * @modified By：
 * @version: $
 */
public class AcWing2_01Package {
    // AcWing 中 class 要为 Main  否则出错
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[] v = new int[N + 1];
        int[] w = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(dp_advanced(N, v, w, V));


    }
    //dp 求解01 背包的 基本方法
    // 01背包方程：  dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - v] + w)
    // 完全背包方程：dp[i][j] = max(dp[i - 1][j], dp[i][j - v] + w)
    // 注意是 dp[i][j - v] + w  这个是推导得到的
    private static int dp_basic(int N, int[] v, int[] w, int V) {

        //dp[i][j] 表示 i 件物品 体积为j 时 最大价值
        int[][] dp = new int[N + 1][V + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {

                dp[i][j] = dp[i - 1][j];

                if (j >= v[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i]] + w[i]);
                }
            }
        }
        return dp[N][V];
    }
    //dp 01背包问题 空间复杂度优化
    private static int dp_advanced(int N, int[] v, int[] w, int V){

        int[] dp = new int[V + 1];
        dp[0] = 0;
        for(int i =0; i<= N ; i++){
            for(int j = V; j >= v[i]; j--){
                dp[j] = Math.max(dp[j],dp[j - v[i]] + w[i]);
            }
        }
        return dp[V];
    }

}
