package com.xiong.LeetCode.SlidingWindow;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/2/6 9:51
 * @description：  1423. 可获得的最大点数  固定窗口大小的滑动窗口
 * @modified By：
 * @version: $
 */
public class Leet1423_maxScore {


    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int sum = 0;
        // 窗口大小为 k
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        int max = sum;
        for (int i = 0;i < k; i++) {
            sum += cardPoints[n - i - 1];
            sum -= cardPoints[k - i - 1];

            max = Math.max(max, sum);
        }

        return max;
    }
}
