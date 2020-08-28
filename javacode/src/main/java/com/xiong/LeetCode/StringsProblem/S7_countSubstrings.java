package com.xiong.LeetCode.StringsProblem;

import java.util.Stack;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/21 17:15
 * @description： 647. 回文子串
 * @modified By：
 * @version: $
 */
public class S7_countSubstrings {
    /**
     * @author: xiongcong
     * @Date: 2020/3/21 17:16
     * @Description: 示例 1:
     * 输入: "abc"
     * 输出: 3
     * 解释: 三个回文子串: "a", "b", "c".
     * <p>
     * 示例 2:
     * 输入: "aaa"
     * 输出: 6
     * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
     * <p>
     * 从字符串的某一位开始，尝试着去扩展子字符串。
     */
    public static void main(String[] args) {
        System.out.println(new S7_countSubstrings().countSubstrings_dp("aba"));
    }

    private int count = 0;

    public int countSubstrings(String s) {

        for (int i = 0; i < s.length(); i++) {
            extendSubstrings(s, i, i); // 以 一个元素为单位
            extendSubstrings(s, i, i + 1);// 以 2 个元素为单位
        }

        return count;
    }

    private void extendSubstrings(String s, int start, int end) {
        //从该元素向两端扩展
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            count++;
        }
    }

    /**
     *  @author: xiongcong
     *  @Date: 2020/8/19 9:04
     *  @Description:
     */
    public int countSubstrings2(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }

        //dp[i][j] 从 i 到 j 的 子串是否是 回文串
        //  s[i] == s[j]  dp[i][j] = dp[i + 1][j - 1]

        int n = s.length();

        boolean[][] dp  = new boolean[n][n];
        int count = 0;
        //init
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
            count++;
        }

        for(int i =  n - 2; i >= 0; i--){
            for(int j = i + 1; j < n; j++){
                if (s.charAt(i) == s.charAt(j)){
                    if (i + 1 < j - 1){
                        dp[i][j] = dp[i + 1][j - 1];
                    }else{
                        dp[i][j] = true;
                    }
                }else{
                    dp[i][j] = false;
                }

                if (dp[i][j]){
                    count++;
                }
            }
        }

        return count;

    }




    /**
     *  @author: xiongcong
     *  @Date: 2020/3/21 18:04
     *  @Description: 动态规划的方法
     */
    //此算法的时间所用比较少，6ms
    public int countSubstrings_dp(String s) {
        int length = s.length();
        int[] dp = new int[length];
        int count = 0;

        for (int i=0; i< length; i++) {
            dp[i] = 1;
            count++;
            for (int j=0; j<i; j++) {
                if (s.charAt(i) == s.charAt(j) && dp[j+1] == 1) {
                    dp[j] = 1;
                    count++;
                } else {
                    dp[j] = 0;
                }
            }
        }
        return count;
    }
}
