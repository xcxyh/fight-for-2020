package com.xiong.JZOffer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/13 10:22
 * @description： 面试题48. 最长不含重复字符的子字符串
 * @modified By：
 * @version: $
 */
public class J48_lengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(new J48_lengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        //滑动窗口法  双指针 加 set
        int left = 0;
        int right = 0;

        Set<Character> set = new HashSet<>();
        char[] chars  = s.toCharArray();

        int len = chars.length;
        int ans = 0;
        while(right < len){
            if (!set.contains(chars[right])){
                set.add(chars[right]);
                right++;
                ans = Math.max(ans, set.size());
            }else {
                set.remove(chars[left]);
                left++;
            }

        }
        return ans;
    }
}
