package com.xiong.LeetCode.GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/12/31 9:58
 * @description： 435. 无重叠区间
 * @modified By：
 * @version: $
 */
public class Leet435_eraseOverlapIntervals {



    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        int ans  = 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] sumInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {

            int[] tempInterval = intervals[i];

            if (sumInterval[1] > tempInterval[0]) {
                ans++;
                sumInterval[1] = Math.min(sumInterval[1], tempInterval[1]);
            }else{
                sumInterval[1] = tempInterval[1];
            }

        }
        return ans;
    }
}
