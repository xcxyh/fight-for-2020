package com.xiong.LeetCode.DynamicProgramming;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/27 11:34
 * @description： 392. 判断子序列
 * @modified By：
 * @version: $
 */
public class Leet392_isSubsequence {

    public static void main(String[] args) {
        isSubsequence_dp("abc", "ahbgdc");
    }

    // dp 预处理 字符串 t
    //f[i][j] 表示字符串 t 中从位置 i 开始往后字符 j 第一次出现的位置

    private static boolean isSubsequence_dp(String s, String t){
        int n = s.length(), m = t.length();

        int[][] dp = new int[m + 1][26];
        // init  如果 dp[i][j] == m 就代表 从位置 i 开始往后字符 j 没有出现过
        for (int i = 0; i < 26; i++) {
            dp[m][i] = m;
        }
        // 预处理 t 字符串 得到 dp数组
        for(int i = m -1; i >=0; i--){
            for(int j = 0; j < 26; j++){
                if (t.charAt(i) == j + 'a'){
                    dp[i][j] = i;
                }else{
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        // 利用 dp 数组的信息, 可以处理多个 s 字符串
        int add = 0;
        for(int i = 0; i < n; i++){
            // == m 表示 从 add 位置开始 ， 字符s.charAt(i) 不存在 于 t 中 ，匹配失败
            if (dp[add][s.charAt(i) - 'a'] == m){
                return false;
            }
            // dp[add][s.charAt(i) - 'a'] 表示 从 add 位置开始 ， 字符s.charAt(i) 第一次出现的位置
            // + 1 表示  以 s.charAt(i) 出现的位置的下一个 位置作为起点 ，继续向后寻找
            add = dp[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }

    // 双指针法
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0 ){
            return true;
        }

        if (t.length() < s.length()){
            return false;
        }

        int slen = s.length();
        int tlen =t.length();
        int i = 0;
        int j = 0;
        while(j < tlen){
            if (s.charAt(i) == t.charAt(j)){
                i++;
                if (i == slen){
                    return true;
                }
            }
            j++;
        }

        return false;
    }
}
