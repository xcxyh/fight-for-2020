package com.xiong.LeetCode.JianZhiOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/13 18:18
 * @description：
 * @modified By：
 * @version: $
 */
public class J10_fib1 {

    public int fib(int n) {
        if (n < 2){
            return n;
        }
        int mod = 1000000007;
        int prepre = 0;
        int pre = 1;
        int ans = 0;
        for(int i = 2; i <= n; i++){
            ans = (prepre + pre) % mod;
            prepre = pre;
            pre = ans;
        }

        return ans % mod;
    }
}
