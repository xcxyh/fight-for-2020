package com.xiong.LeetCode.DynamicProgramming;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/11 11:21
 * @description：  96. 不同的二叉搜索树
 * @modified By：
 * @version: $
 */
public class Leet96_numTrees {

    //  又名 卡特兰数  有 公式 可以直接调用
    // 卡特兰数 例子：
    // 1 给定N个节点，能构成多少种不同的二叉搜索树？
    // 2 n对括号正确匹配数目
    public int numTrees(int n) {
        // dp[i] 表示 以 1 ... i 为节点组成的二叉搜索树有多少种

        // dp[i] =  f(1) + f(2) + ... + f(i) , f(x) 表示 以 x 为 根节点的 二叉搜索树有多少种

        // 在  1 ... i 这些节点中 ，若 x 为根节点， 则 x 的左子树 有 dp[x - 1] 种情况
        // x  的右子树 有 dp[i - x] 种情况，则 f(x) = dp[x - 1]* dp[i - x]
        // 注意： 二叉搜索树有多少种 与节点的大小无关， 与节点的个数有关
        int[] dp = new int[n + 1];
        //init
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i ++){
            for(int x = 1; x <= i; x++){
                dp[i] += dp[x - 1] * dp[i - x];
            }
        }
        return dp[n];

    }



    public int numTrees_old(int n) {
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
