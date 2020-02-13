package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/1/31 14:28
 * @description： 正则表达式匹配
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * @modified By：
 * @version: $
 */
public class J19_ZhenzeMatch {

    public static void main(String[] args) {
        System.out.println(match(new char[]{'a','a','a','a','b','c'}, new char[]{'a','*','a','b','c'}));
    }

    /**
     * @author: xiongcong
     * @Date: 2020/1/31 14:38
     * @Description: 递归
     */
    public static boolean match(char[] str, char[] pattern) {

        if (str == null || pattern == null) {
            return false;
        }
        //TO DO
        return matchstr(str, pattern, 0, 0);
    }

    public static boolean matchstr(char[] str, char[] pattern, int s, int p) {
        if (s == str.length && p == pattern.length) {
            return true;
        }

        if (s < str.length && p == pattern.length) {
            return false;
        }
        //当第二个字符为 *  此时：
        //1 第一个字符不相等  ab 和 c*ab
        //2 第一个字符相等 此时有三种情况
            // 2.1  abc 和 a*bc
            // 2.2  abc 和 a*abc
            // 2.3  aaaabc和a*abc
        if(p < pattern.length - 1 && pattern[p + 1] == '*'){// p < pattern.length - 1 是为了保证 p+1 不会越界
                //第一个字符相等
            if (s <= str.length && (str[s] == pattern[p] || pattern[p] == '.')) {
                return (
                // 2.1  abc 和 a*bc
                matchstr(str, pattern , s + 1, p + 2)||
                // 2.2  abc 和 a*abc
                matchstr(str, pattern , s, p + 2)||
                // 2.3  aaaabc和a*abc
                matchstr(str, pattern , s + 1, p)
                );

            }else{ // 第一个字符不相等  ab 和 c*ab
                //匹配字串
                return matchstr(str, pattern , s, p + 2);
            }

        }else { //当第二个字符不为 *
            //比较第一个字符是否相等
            if (s <= str.length && (str[s] == pattern[p] || pattern[p] == '.')) {
                //匹配字串
                return matchstr(str, pattern, s + 1, p + 1);
            }
        }
        return false;
    }

    /**
     *  @author: xiongcong
     *  @Date: 2020/1/31 15:21
     *  @Description: 动态规划解法  没看懂，不过跟上面的分析一致
     */
    public boolean match_dp(char[] str, char[] pattern) {

        int m = str.length, n = pattern.length;
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        for (int i = 1; i <= n; i++)
            if (pattern[i - 1] == '*')
                dp[0][i] = dp[0][i - 2];

        //当第二个字符为 *  此时：
        //1 第一个字符不相等  ab 和 c*ab
        //2 第一个字符相等 此时有三种情况
        // 2.1  abc 和 a*bc
        // 2.2  abc 和 a*abc
        // 2.3  aaaabc和a*abc
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (pattern[j - 1] == '*')
                    if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.') {
                        dp[i][j] |= dp[i][j - 1]; // a* counts as single a abc 和 a*bc
                        dp[i][j] |= dp[i - 1][j]; // a* counts as multiple a  aaaabc和a*abc
                        dp[i][j] |= dp[i][j - 2]; // a* counts as empty  abc 和 a*abc
                    } else
                        dp[i][j] = dp[i][j - 2];   // a* only counts as empty

        return dp[m][n];
    }


}
