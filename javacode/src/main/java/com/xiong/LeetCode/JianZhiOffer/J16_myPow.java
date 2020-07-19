package com.xiong.LeetCode.JianZhiOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/16 16:45
 * @description： 剑指 Offer 16. 数值的整数次方
 * @modified By：
 * @version: $
 */
public class J16_myPow {

    public double myPow(double x, int n) {
        int N = n;
        // n 为负 ，
        if (n < 0){
            // n 为 Integer.MIN_VALUE  的特殊情况
            if (n == Integer.MIN_VALUE){
                return 1 / x * myPow(1 / x, Integer.MAX_VALUE);
            }
            // n 为负的处理
            N = -n;
            x = 1 / x;
        }
        // base case
        if (N == 0){
            return 1.0;
        }
        // n 为 奇数
        if ( (N & 1) == 1){
            return myPow(x, N - 1) * x;
        }
        // n 为 偶数
        return myPow( x*x , N / 2);

    }
}
