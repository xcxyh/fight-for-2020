package com.xiong.LeetCode.SlidingWindow;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/2/10 15:41
 * @description： 567. 字符串的排列   固定窗口的 滑动窗口题
 * @modified By：
 * @version: $
 */
public class Leet567_checkInclusion {

    public boolean checkInclusion(String s1, String s2) {
        int[] arr1 =new int[26];
        int[] arr2 =new int[26];

        // 这里 固定窗口 的大小 为 s1 的长度
        for (char c : s1.toCharArray()) {

            arr1[c - 'a']++;
        }
        int n1 = s1.length();
        int n2 = s2.length();

        if (n2 < n1) {
            return false;
        }

        for (int i = 0; i < n1; i++) {
            arr2[s2.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = n1 - 1;

        while (right < n2) {

            if (isnotMatch(arr1, arr2)) {

                arr2[s2.charAt(left) - 'a']--;

                left++;
                right++;

                if (right < n2) {
                    arr2[s2.charAt(right) - 'a']++;
                }

            }else {
                return true;
            }

        }

        return false;

    }

    // 判断是否是s1 的一个排列 不是 返回 true
    private boolean isnotMatch(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {

            if (arr1[i] != arr2[i]) {
                return true;
            }
        }
        return false;
    }
}
