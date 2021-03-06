package com.xiong.LeetCode.FenZhi;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/2/27 14:57
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet395_longestSubstring {

    public int longestSubstring(String s, int k) {
        int n = s.length();

        return dfs(s, 0, n - 1, k);
    }

    private int dfs(String s, int left, int right, int k) {

        int[] arr = new int[26];
        for (int i = left; i <= right; i++) {
            arr[s.charAt(i) - 'a']++;

        }
        char split = '#';
        for (int i = 0; i < 26; i++) {
            if (0 < arr[i] && arr[i] < k) {
                split = (char)(i + 'a');
                break;
            }
        }
        if (split == '#') {
            return right - left + 1;
        }

        int i = left;
        int max = 0;
        // 对由split分隔的所有片段 dfs
        // 取最大的
        while (i <= right) {
            while (i <= right && s.charAt(i) == split) {
                i++;
            }

            if (i > right) {
                break;
            }
            int start = i;

            while (i <= right && s.charAt(i) != split) {
                i++;
            }
            int len =  dfs(s, start, i - 1, k);
            max = Math.max(max, len);
        }

        return max;
    }
}
