package com.xiong.LeetCode.JianZhiOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/25 12:58
 * @description： 面试题49. 丑数
 * @modified By：
 * @version: $
 */
public class J49_nthUglyNumber {

    public int nthUglyNumber(int n) {
        if (n <= 5){
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int index_2 = 0; int index_3 = 0; int index_5= 0;
        for(int i = 1; i < n; i++){
            int next2 = dp[index_2]*2;
            int next3 = dp[index_3]*3;
            int next5 = dp[index_5]*5;
            dp[i] = min(next2, next3, next5);
            if (dp[i] == next2){
                index_2++;
            }
            if (dp[i] == next3){ // 不能加 else
                index_3++;
            }
            if (dp[i] == next5){
                index_5++;
            }
            //System.out.print(dp[i] + " " );
        }
        return dp[n - 1];
    }

    private int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
}
