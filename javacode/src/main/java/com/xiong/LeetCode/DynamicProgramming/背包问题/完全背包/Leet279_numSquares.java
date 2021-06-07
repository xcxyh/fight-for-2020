package com.xiong.LeetCode.DynamicProgramming.背包问题.完全背包;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 上的完全背包问题
 * 279. 完全平方数
 * 322. 零钱兑换
 * 518. 零钱兑换II
 * 1449. 数位成本和为目标值的最大数字
 */

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/23 15:38
 * @description： 279. 完全平方数  此题也可转化为 完全背包问题 使用 dp 求解
 * 解法1： BFS 广度优先搜索
 * <p>
 * 解法2：四平方和 定理
 * <p>
 * 解法3：动态规划，转化为 完全背包问题 使用 dp 求解
 * <p>
 * 。。。
 * @modified By：
 * @version: $
 */
public class Leet279_numSquares {

    public static void main(String[] args) {
        System.out.println(numSquares_bfs(4));
    }

    /**
     * @author: xiongcong
     * @Date: 2020/4/23 15:41
     * @Description: 转化为 完全背包问题 使用 dp 求解
     */
    public int numSquares_dp(int n) {
        if (n <= 1) {
            return n;
        }

        int max = 1;

        while (max * max <= n) {
            max++;
        }

        //dp[i][j] 表示 使用前 i 个完全平方数表示 j 最少 的个数
        //dp[i][j] = min (dp[i-1][j], dp[i-1][j- i^2]+1,dp[i-1][j- 2*i^2]+ 2,....)
        //完全背包问题
        int[][] dp = new int[max + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[1][i] = i;
        }
        for (int i = 2; i < max; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= i * i) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - i * i] + 1);
                }

            }
        }
        return dp[max - 1][n];
    }



    public int numSquares(int n) {

        Queue<Integer> q = new LinkedList<>();

        q.offer(n);
        // 从 n 到 0 至少需要几步
        int step = 0;
        while (! q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {
                int t = q.poll();
                int max = (int) Math.floor(Math.sqrt(t));

                for (int i = max; i >= 0; i--) {
                    if (t - i * i == 0) {
                        return step+ 1;
                    }else {
                        q.offer(t - i * i);
                    }
                }
            }

            step++;

        }

        return 0;

    }

    /**
     * @author: xiongcong
     * @Date: 2020/4/23 16:04
     * @Description: 四平方和定理   numSquares_math(n) 最大为 4
     *
     * 1： n 满足  n / 4^k % 8 == 7  则 结果为 4
     *
     * 2：该数 为 一个完全平方数 返回 1
     *
     * 3：使用枚举判断 一个数能否拆分为 2 个 完全平方数 ，可以返回 2
     *
     * 4： 其他情况 直接返回 3
     *
     */
    public int numSquares_math(int n) {
        // four-square and three-square theorems.
        while (n % 4 == 0)
            n /= 4;
        if (n % 8 == 7)
            return 4;

        if (this.isSquare(n))
            return 1;
        // enumeration to check if the number can be decomposed into sum of two squares.
        for (int i = 1; i * i <= n; ++i) {
            if (this.isSquare(n - i * i))
                return 2;
        }
        // bottom case of three-square theorem.
        return 3;
    }

    private boolean isSquare(int n) {
        int sq = (int) Math.sqrt(n);
        return n == sq * sq;
    }

    //bfs   将此题目抽象为，要从n走到0，每次跨越的距离只能为平方数，求最少的跨越次数。
    public static int numSquares_bfs(int n) {

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(n);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int num = queue.poll();

                for (int j = (int) Math.floor(Math.sqrt(num)); j > 0; j--) {

                    if (num == j * j) {
                        return step + 1;
                    } else {
                        queue.offer(num - j * j);
                    }

                }
            }
            step++;
        }
        return 0;
    }

}
