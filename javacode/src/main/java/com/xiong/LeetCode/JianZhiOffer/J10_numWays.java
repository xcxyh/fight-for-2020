package com.xiong.LeetCode.JianZhiOffer;

import java.util.Scanner;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/30 10:10
 * @description：   剑指 Offer 10- II. 青蛙跳台阶问题
 * @modified By：
 * @version: $
 */
public class J10_numWays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        if(N==0){
            System.out.print(1);
            return;
        }
        if (N==1 ) {
            System.out.print(1);
            return;
        }

        if (N==2 ) {
            System.out.print(2);
            return;
        }

        long[][] dp=new long[N+1][3];
        dp[0][1]=1;
        dp[0][2]=1;
        dp[1][1]=1;
        dp[1][2]=1;
        for(int i=2;i<N+1;i++){
            //两种情况
            dp[i][1]=dp[i-1][1]+dp[i-2][2];
            //
            dp[i][2]=dp[i-1][1];
        }
        System.out.print(Math.max(dp[N][1],dp[N][2]));
    }


    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n <= 2 ){
            return n;
        }

        int pre_one = 1;

        int pre_two = 2;
        int ans = 0;
        int mod = 1000000007;
        for(int i = 3; i <= n; i++){
            ans = (pre_one + pre_two)% mod;
            pre_one = pre_two;
            pre_two = ans;
        }
        return ans % mod;
    }

}
