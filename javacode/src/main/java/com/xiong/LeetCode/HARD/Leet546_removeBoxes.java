package com.xiong.LeetCode.HARD;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/15 19:08
 * @description： 546. 移除盒子
 * @modified By：
 * @version: $
 */
public class Leet546_removeBoxes {

    public int removeBoxes(int[] boxes) {
        // 用于存储之前计算过的状态，避免重复计算
        int[][][] dp = new int[100][100][100];
        return cal(boxes, dp, 0, boxes.length - 1, 0);
    }

    public int cal(int[] boxes, int[][][] dp, int l, int r, int k) {
        if (l > r) {
            return 0;
        }
        if (dp[l][r][k] != 0) {
            return dp[l][r][k];
        }
        // 计算右边有几个跟最右边一个（boxes[r]）相等,
        // 如果相等则把右边界左移到不相同的元素之后一个为止，移动过程中同步改动k
        while (r > l && boxes[r] == boxes[r-1]) {
            r--;
            k++;
        }
        // 计算把右边k+1个消除时的得分
        dp[l][r][k] = cal(boxes, dp, l, r-1, 0) + (k+1)*(k+1);
        // 从右边界开始向左寻找跟外部k个元素相等的元素，如果相等则剔除掉这些不相等的，让后面一段连起来。
        // 此时得分就是中间消除中间一段不连续部分的得分和剩下来部分的得分
        // 比较这个得分和原来计算过其他方案的得分，去最大值覆盖到状态数组dp中
        for (int i = r-1; i >= l; --i) {
            if (boxes[i] == boxes[r]) {
                dp[l][r][k] = Math.max(dp[l][r][k],
                        cal(boxes, dp, l, i, k+1) + cal(boxes, dp, i+1, r-1, 0));
            }
        }
        return dp[l][r][k];

    }
}
