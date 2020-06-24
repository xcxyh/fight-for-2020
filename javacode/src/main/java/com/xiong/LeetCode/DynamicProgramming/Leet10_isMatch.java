package com.xiong.LeetCode.DynamicProgramming;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/20 9:56
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet10_isMatch {

    public boolean isMatch(String s, String p) {
        return dp_memo(s, p);
    }





    // 以下解法为 dp()函数 + memo 备忘录 的形式，不同于 dp[][] table 的形式
    private Boolean[][] memo;
    private boolean dp_memo(String s, String p){
        int m = s.length();
        int n = p.length();

        memo = new Boolean[m + 1][n + 1]; // 注意初始化的大小

        return dp(s, p, 0, 0);
    }
    // i， j 为 s， p 中的 下标
    // 加备忘录优化的 dp
    private boolean dp(String s, String p, int i, int j){
        if (memo[i][j] != null){
            return memo[i][j];
        }
        if (j == p.length()){
            return i == s.length();
        }

        boolean firstMatch = i < s.length()
                && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        // 当p 的第二个字符为 * 时， 考虑：
        // 1 *匹配0 次当前子符，则跳过 x* 两个位置， 继续匹配
        // 2 * 匹配一次当前字符，并保留* 的情况
        boolean ans;
        if ( j <= p.length() - 2 && p.charAt(j + 1) == '*'){
            ans = dp(s, p, i, j + 2) || (firstMatch && dp(s, p, i + 1, j));
        }else{
            ans = firstMatch && dp(s, p, i + 1, j + 1);
        }
        memo[i][j] = ans;
        return ans;

    }

    // 暴力 dp， 这种方式相比于 dp[][] table 更好理解 ，但是 需要备忘录优化
    private boolean dp(String s, String p){
        if (p == null || p.length() == 0){
            return (s == null || s.length() == 0);
        }

        // 判断它们的第一个字符是否匹配
        boolean firstMatch = !s.isEmpty()
                && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        // 当p 的第二个字符为 * 时， 考虑：
        // 1 *匹配0 次当前子符
        // 2 * 匹配一次当前字符，并保留* 向后继续匹配的情况
        if (p.length() >= 2 && p.charAt(1) == '*'){
            return dp(s,p.substring(2)) || (firstMatch && dp(s.substring(1), p));
        }else{
            return firstMatch && dp(s.substring(1), p.substring(1));
        }
    }
}
