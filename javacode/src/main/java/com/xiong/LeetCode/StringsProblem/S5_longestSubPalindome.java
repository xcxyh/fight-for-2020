package com.xiong.LeetCode.StringsProblem;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/21 18:24
 * @description： 5. 最长回文子串  与 647. 回文子串 基本相同
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * @modified By：
 * @version: $
 */
public class S5_longestSubPalindome {
    /**
     * @author: xiongcong
     * @Date: 2020/3/21 18:25
     * @Description: 也可以通过扩展字符串的方式 和 动态规划的方式
     */
    public static void main(String[] args) {
        System.out.println(new S5_longestSubPalindome().longestPalindrome("asadbbdzaxs"));
    }

    private int maxLen = 0;
    private String subString;

    public String longestPalindrome(String s) {
        if(s.length() <= 1) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            extendSubstring(s, i, i);
            extendSubstring(s, i, i + 1);
        }

        return subString;
    }

    private void  extendSubstring(String s, int start,int end){

        while (start >= 0 && end < s.length() && s.charAt(start)==s.charAt(end)){

            if (end - start + 1> maxLen){
                maxLen = end - start + 1;
                subString = s.substring(start,end + 1);
            }
            start--;
            end++;
        }

    }
}
