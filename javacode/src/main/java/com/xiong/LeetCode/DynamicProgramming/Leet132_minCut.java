package com.xiong.LeetCode.DynamicProgramming;

import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/3/8 10:32
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet132_minCut {

    public int minCut(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();

        boolean[][] p = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(p[i], true);
        }

        // 得到 p[i][j] 来判断 从 i 到 j 的子串是否是回文串
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {

                p[i][j] = (s.charAt(i) == s.charAt(j)) & p[i + 1][j - 1];
            }
        }

        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {

            if (p[0][i]) {
                f[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    // 0 -> j  and  j + 1 -> i
                    if (p[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }

        return f[n - 1];
    }

}
