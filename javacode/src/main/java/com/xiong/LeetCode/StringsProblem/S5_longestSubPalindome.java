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
        System.out.println(new S5_longestSubPalindome().longestPalindrome("dbabd"));
    }

    private int maxLen = 0;
    private String subString;

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            extendSubstring(s, i, i);  //从一位 的 子串开始扩展
            extendSubstring(s, i, i + 1); //从两位的子串开始扩展
        }

        return subString;
    }

    private void extendSubstring(String s, int start, int end) {

        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {

            if (end - start + 1 > maxLen) {
                maxLen = end - start + 1;
                subString = s.substring(start, end + 1);
            }
            start--;
            end++;
        }

    }

    //能 ac  的 dp 写法
    public String longestPalindrome_dp(String s) {
        //dp
        if (s == null || s.length() == 0) {
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        //先将 i==j 的地方初始化为true
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int maxStart = 0;
        int maxEnd = 0;
        //dp 表示 子串 s[i,j] 是否为 回文串
        // dp[i][j] = dp[i+1][j-1] && Sj == Si
        //边界为 i + 1 <= j -1  -->  j - i >= 2
        //先遍历列 否则出错
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                boolean flag = s.charAt(i) == s.charAt(j); // 该子串首尾是否相同
                if (j - i >= 2) {
                    dp[i][j] = dp[i + 1][j - 1] && flag;
                } else {
                    dp[i][j] = flag;
                }
                if (dp[i][j] && j - i > maxEnd - maxStart) {
                    maxStart = i;
                    maxEnd = j;
                }

            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }
}
