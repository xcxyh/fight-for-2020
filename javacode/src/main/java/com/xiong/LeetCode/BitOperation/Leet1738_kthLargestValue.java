package com.xiong.LeetCode.BitOperation;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/5/19 12:20
 * @description： 1738. 找出第 K 大的异或坐标值
 * @modified By：
 * @version: $
 */
public class Leet1738_kthLargestValue {

    private int m = 0;
    private int n = 0;
    public int kthLargestValue(int[][] matrix, int k) {
        m = matrix.length;
        n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        for (int i = 1;i < m; i++) {
            dp[i][0] = dp[i - 1][0] ^ matrix[i][0];
        }
        for (int i = 1;i < n; i++) {
            dp[0][i] = dp[0][i - 1] ^ matrix[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] ^ dp[i][j - 1] ^ dp[i - 1][j - 1] ^ matrix[i][j];
            }
        }

        return findk(dp, k);
    }

    private int findk(int[][] dp, int k) {
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (queue.size() < k) {
                    queue.offer(dp[i][j]);
                }else {
                    if (queue.peek() < dp[i][j]) {
                        queue.poll();
                        queue.offer(dp[i][j]);
                    }
                }
                //System.out.print(dp[i][j] + " ");
            }
        }

        return queue.peek();


    }
}
