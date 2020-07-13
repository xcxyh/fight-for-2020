package com.xiong.LeetCode.DynamicProgramming;

import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/25 16:15
 * @description： 139. 单词拆分
 * @modified By：
 * @version: $
 */
public class Leet139_wordBreak {

    //dp
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0){
            return true;
        }
        int n = s.length();
        boolean[] dp = new boolean[n + 1];

        dp[0] = true;
        for(int i = 1 ; i <= n; i++){

            for(int j = 0; j < i; j++){
                dp[i] = dp[i] || (dp[j] && wordDict.contains(s.substring(j, i)));
            }
        }
        return dp[n];
    }
}
