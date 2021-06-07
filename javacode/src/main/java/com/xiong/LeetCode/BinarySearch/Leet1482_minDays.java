package com.xiong.LeetCode.BinarySearch;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/5/9 10:59
 * @description：  1482. 制作 m 束花所需的最少天数   Leet1011 相同， 二分，
 * 共同点：所求结果是单调的，有明确的上下边界，选择使用二分寻找，然后写一个 check 函数作为二分中的条件， （这里是 是否能制作m 束花）
 * @modified By：
 * @version: $
 */
public class Leet1482_minDays {

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        if (m * k > n) {
            return -1;
        }

        int low = Integer.MAX_VALUE;
        int high = 0;

        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        while (low < high) {
            int days = low + (high - low) / 2;

            if (canMake(bloomDay, m, k, days)) {
                high = days;
            }else {
                low = days + 1;
            }
        }

        return low;
    }


    private boolean canMake(int[] bloomDay, int m, int k, int days) {

        int ret = 0;

        int flowers = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= days) {
                flowers++;
                if (flowers == k) {
                    ret++;
                    flowers = 0;
                }
            }else {
                flowers = 0;
            }

        }
        return ret >= m;
    }
}
