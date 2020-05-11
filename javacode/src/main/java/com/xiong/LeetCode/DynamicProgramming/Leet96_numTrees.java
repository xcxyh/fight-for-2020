package com.xiong.LeetCode.DynamicProgramming;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/11 11:21
 * @description：  96. 不同的二叉搜索树
 * @modified By：
 * @version: $
 */
public class Leet96_numTrees {

    public int numTrees(int n) {
        //dp
        //dp[i] 表示 从 1 到 i 为节点组成的 BST 有多少种
        int[] dp = new int[n + 1];
        // dp[i] = 以1 为根节点时的 数目 + 以 2 为根节点时的数目 + 。。。+ 以 i 为根节点时的数目
        //
        //dp[i] = sum(dp[0]*dp[i - 1], ..., dp[i - 1] * dp[0])
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            // 以 数字  j 为根节点 时 共有 dp[j-1]* dp[i - j] 种
            for(int j = 1; j <= i; j++){

                dp[i] = dp[i] + dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];

    }
}
