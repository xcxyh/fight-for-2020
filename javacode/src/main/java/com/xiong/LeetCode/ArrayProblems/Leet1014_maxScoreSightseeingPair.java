package com.xiong.LeetCode.ArrayProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/17 10:55
 * @description： 1014. 最佳观光组合  解法：拆分 为 A[i] + i 和 A[j] - j
 * @modified By：
 * @version: $
 */
public class Leet1014_maxScoreSightseeingPair {

    // 数学题  拆成  变化的一部分， 和 不变的一部分
    public int maxScoreSightseeingPair(int[] A) {

        int n = A.length;

        //拆分 为 A[i] + i 和 A[j] - j
        int maxAI = 0;

        int ans = 0;

        for(int j = 1; j < n; j++){
            // 寻找 A[i] + i 部分的最大值
            maxAI = Math.max(maxAI, A[j-1] + j - 1);
            // 以 j 为 结尾的 最大评分
            int t = maxAI + A[j] - j;

            ans = Math.max(ans, t);
        }

        return ans;
    }
}
