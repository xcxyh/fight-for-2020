package com.xiong.LeetCode.SlidingWindow;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/2/2 10:30
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet424_characterReplacement {

    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] arr = new int[26];
        int n = s.length();
        int left = 0;
        int right = 0;

        int maxn = 0;

        while(right < n) {

            arr[s.charAt(right) -'A']++;
            maxn = Math.max(maxn, arr[s.charAt(right) -'A']);
            if (right - left + 1 - maxn > k) {
                arr[s.charAt(left) - 'A']--;
                left++;
            }
            right++;

        }

        return right - left;
    }
}
