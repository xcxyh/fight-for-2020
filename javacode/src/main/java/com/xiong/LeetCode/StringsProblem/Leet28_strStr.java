package com.xiong.LeetCode.StringsProblem;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/19 14:12
 * @description： 28. 实现 strStr()
 * @modified By：
 * @version: $
 */
public class Leet28_strStr {

    public int strStr(String haystack, String needle) {

        kmp(haystack, needle); // 方法1

        return baoli(haystack, needle); //方法2
    }

    // 暴力遍历
    private int baoli(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        int m = haystack.length();
        int n = needle.length();

        for (int i = 0; i <= m - n; i++) {
            int j;
            for (j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    //KMP 字符串匹配算法
    private int kmp(String haystack, String needle) {

        if (needle == null || needle.length() == 0) {
            return 0;
        }
        //获得 next 数组
        int[] next = getNextArr(needle);

        int m = haystack.length();
        int n = needle.length();

        int i = 0;
        int j = 0; // needle 上的位置

        while (i < m && j < n) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == n) {
            return i - j;
        } else {
            return -1;
        }
    }

    private int[] getNextArr(String pattern) {

        int n = pattern.length();

        int[] next = new int[n + 1];

        int k = -1;
        int j = 0;
        next[0] = -1;

        while (j < n) {

            if (k == -1 || pattern.charAt(k) == pattern.charAt(j)) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }

        return next;

    }

}
