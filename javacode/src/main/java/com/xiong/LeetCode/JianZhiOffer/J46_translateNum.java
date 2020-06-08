package com.xiong.LeetCode.JianZhiOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/8 16:23
 * @description： 面试题46. 把数字翻译成字符串  递归  dp 都可以
 * @modified By：
 * @version: $
 */
public class J46_translateNum {
    //递归
    public int translateNum(int num) {
        if (num <= 9) {
            return 1;
        }
        int ba = num % 100;
        if (ba >= 10 && ba <= 25) {
            return translateNum(num / 100) + translateNum(num / 10);
        } else {
            return translateNum(num / 10);
        }
    }

    // 动态规划 dp  跟上台阶差不多
    public int translateNum_dp(int num) {
        String str = String.valueOf(num);
        int n = str.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            char cur = str.charAt(i - 1);
            char pre = str.charAt(i - 2);
            if ((pre == '1' && cur >= '0' && cur <= '9')
                    || (pre == '2' && cur >= '0' && cur <= '5')) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }


}
