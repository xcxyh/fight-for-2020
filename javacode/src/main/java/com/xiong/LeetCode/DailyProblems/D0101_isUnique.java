package com.xiong.LeetCode.DailyProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/7 12:35
 * @description：
 * @modified By：
 * @version: $
 */
public class D0101_isUnique {
    public static void main(String[] args) {
        System.out.println(isUnique("leetcode"));
    }

    public static boolean isUnique(String astr) {
        if (astr == null || astr.length() == 0) {
            return true;
        }

        int[] bucket = new int[100];
        for (char c : astr.toCharArray()) {
            bucket[c - 'A']++;
        }
        for (int n : bucket) {
            if (n > 1) {
                return false;
            }
        }
        return true;
    }
}
