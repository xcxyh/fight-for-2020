package com.xiong.LeetCode.BitOperation;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/11 9:52
 * @description： 372. 超级次方
 * @modified By：
 * @version: $
 */
public class Leet372_superPow {

    private int mod = 1337;
    public int superPow(int a, int[] b) {

        return superPow(a, b, b.length);
    }

    private int superPow(int a, int[] b, int end){
        if (end == 0){
            return 1;
        }
        a = a % mod;

        int last = b[end - 1];

        return mypow(a, last) * mypow(superPow(a, b, end - 1), 10) % mod;

    }
    // 只针对 n 为正整数， 且 不超过 int 范围
    private int mypow(int a, int n){

        if (n == 0){
            return 1;
        }
        a = a % mod;
        // 有乘法的地方都需要 mod
        if (n % 2 == 1){
            return a * mypow(a, n - 1) % mod;
        }
        int sub = mypow(a, n / 2);

        return sub * sub % mod ;
    }
}
