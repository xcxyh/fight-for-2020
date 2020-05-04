package com.xiong.LeetCode.StringsProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/9 18:03
 * @description： 3. 无重复字符的最长子串 滑动窗口法
 * @modified By：
 * @version: $
 */
public class Leet3_lengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() <= 1) {
            return s.length();
        }
        //双指针 + set 实现滑动窗口
        Set<Character> window = new HashSet<>();

        int left = 0; //滑动窗口 左端点
        int right = 0;//滑动窗口 右端点

        int ans = 0;
        char[] chars = s.toCharArray();
        int len = chars.length;
        while (left < len && right < len) {

            if (! window.contains(chars[right])) {
                window.add(chars[right]);
                right++;
            } else {
                window.remove(chars[left]);
                left++;
                ans = Math.max(ans, right - left + 1);
            }

        }
        return ans;
    }
}
