package com.xiong.LeetCode.SlidingWindow;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/2/5 13:35
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet1208_equalSubstring {

    public int equalSubstring(String s, String t, int maxCost) {
        int cost = 0;
        int n = s.length();

        int left= 0;
        int right = 0;
        // 这个窗口只会增大 不会减小
        while( right < n) {
            int a = s.charAt(right) - 'a';
            int b = t.charAt(right) - 'a';

            cost += Math.abs(a - b);

            if (cost > maxCost) {
                int c = s.charAt(left) - 'a';
                int d = t.charAt(left) - 'a';
                cost -= Math.abs(c - d);
                left++;
            }
            right++;
        }

        return right - left;
    }
}
