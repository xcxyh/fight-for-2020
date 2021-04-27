package com.xiong.LeetCode.HARD;

import java.util.TreeSet;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/4/22 13:53
 * @description： 363. 矩形区域不超过 K 的最大数值和   前缀和 + treeSet
 * @modified By：
 * @version: $
 */
public class Leet363_maxSumSubmatrix {


    // 枚举 所求矩形的上下边界，然后 按列求和得到 一维数组，求这个一维数组的 不超过target的最大区间和
    public int maxSumSubmatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 初始化为 MIN_VALUE
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) { // 枚举上边界
            int[] sum = new int[n];
            for (int j = i; j < m; j++) { // 枚举下边界

                // 按列求和 ， 得到 一个一维数组
                for (int k = 0; k < n; k++) {
                    sum[k] = sum[k] + matrix[j][k];
                }
                // 对 每一轮的  sum 数组 求 最大区间和
                TreeSet<Integer> set = new TreeSet<>();
                // 前缀和方法中，先添加 0 ，因为当 s == target 时，存在 min_left = 0
                set.add(0);
                int s = 0;

                for (int x : sum) {
                    s += x;
                    // 求set 中 大于等于 s - target 的 最小值， 即 s - min_left 为 不超过target的最大区间和
                    Integer min_left = set.ceiling(s - target);

                    if (min_left != null) {
                        ans = Math.max(ans, s - min_left);
                    }

                    set.add(s);
                }

            }
        }

        return ans;
    }
}
