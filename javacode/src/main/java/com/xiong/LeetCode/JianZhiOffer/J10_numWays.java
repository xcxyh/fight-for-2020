package com.xiong.LeetCode.JianZhiOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/30 10:10
 * @description：   剑指 Offer 10- II. 青蛙跳台阶问题
 * @modified By：
 * @version: $
 */
public class J10_numWays {

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
