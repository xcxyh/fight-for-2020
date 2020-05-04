package com.xiong.LeetCode.BackTracking;


import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/4 20:31
 * @description：  131. 分割回文串  回溯 + dp table 优化
 * @modified By：
 * @version: $
 */
public class Leet131_partition {

    public static void main(String[] args) {
        System.out.println(new Leet131_partition().partition("aab"));
    }

    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            ans.add(new ArrayList<>());
            return ans;
        }

        boolean[][] dp =  patition_dp(s); //预先保存子串是否是回文串的结果 来优化 时间复杂度

        backtracking(s, 0, new ArrayList<>(), dp);
        return ans;
    }
    //回溯 关键是确定 剪枝条件
    private void backtracking(String s, int cur, List<String> list, boolean[][] dp) {
        if (cur == s.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = cur; i < s.length(); i++) {

            if (!dp[cur][i]) { //剪枝条件
                continue;
            }
            list.add(s.substring(cur, i + 1));
            backtracking(s, i + 1, list, dp);
            list.remove(list.size() - 1);
        }


    }
    //找出 s 分割出的所有子串 中的回文串
    private boolean[][] patition_dp(String s){
        //dp[i][j] 从i 到j 的子串 是否是回文串
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
              dp[i][j] =  isPalindrome(s, i ,j);
            }
        }
        return dp;
    }

    //判断一个字符串是否是 回文串
    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
