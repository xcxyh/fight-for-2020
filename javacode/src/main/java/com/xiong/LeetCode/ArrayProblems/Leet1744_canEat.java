package com.xiong.LeetCode.ArrayProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/6/1 16:00
 * @description：   1744. 你能在你最喜欢的那天吃到你最喜欢的糖果吗？
 * @modified By：
 * @version: $
 */
public class Leet1744_canEat {

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = queries.length;

        boolean[] ans = new boolean[n];
        // 防溢出  用  long
        long[] capsum = new long[candiesCount.length + 1];

        for (int i = 0; i < candiesCount.length; i++) {
            capsum[i + 1] = capsum[i] + candiesCount[i];
        }

        for (int i = 0; i < n; i++) {

            int ftype = queries[i][0];
            int fday = queries[i][1];
            int fcap = queries[i][2];
            // 最少能吃的糖果数
            long x1 = fday + 1;
            // 最多能吃的糖果数
            long y1 =(long) (fday + 1) * fcap;
            // 第 ftype 类糖果 所在的区间
            long x2 = capsum[ftype] + 1;
            long y2 = capsum[ftype + 1];
            // 区间相交
            ans[i] = !(x1 > y2 || y1 < x2);
        }

        return ans;
    }
}
