package com.xiong.LeetCode.DynamicProgramming.线性DP;

import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/23 11:49
 * @description： 354. 俄罗斯套娃信封问题  左端点排序后 求 右端点的 最长上升子序列
 * @modified By：
 * @version: $
 */
public class Leet354_maxEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 || envelopes[0].length == 0){
            return 0;
        }

        int n = envelopes.length;
        // 按照 宽排序
        Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 0;
        // 然后就是  对长 求一个 最长上升子序列
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] =Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
