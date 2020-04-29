package com.xiong.LeetCode.BitOperation;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/26 11:26
 * @description： 50. Pow(x, n)
 * @modified By：
 * @version: $
 */
public class Leet50_myPow {

    public static void main(String[] args) {
        System.out.println(new Leet50_myPow().myPow_nonRec(3.0, 5));
    }


    public double myPow(double x, int n) {
        return myPow_nonRec(x, n);
    }

    //非递归
    private double myPow_nonRec(double x, int n) {
        long N = n; // 防止 n == Integer.MIN_VALUE 转 整数 会溢出 所以用long保存
        if (N < 0) {
            N = -N;
            x = 1.0 / x;
        }
        double pow = 1;

        while (N > 0) {
            if ((N & 1) == 1) { //奇数 N % 2 == 1
                pow = pow * x;
            }
            x = x * x;
            N = N >> 1;// N = N / 2
        }
        return pow;
    }


    //递归
    private double myPow_recusive(double x, int n) {
        if (n == 0) { // base case
            return 1.0;
        }

        if (n < 0) { // 负数情况
            if (n == Integer.MIN_VALUE) { // 极端情况
                return (1.0 / x) * myPow(1.0 / x, Integer.MAX_VALUE);
            }
            return 1.0 / myPow(x, -n);
        }

        if (n % 2 == 1) { // 奇数情况 可以写成 (N & 1) == 1
            return x * myPow(x, n - 1);
        }
        return myPow(x * x, n / 2); // 快速幂法, n/2 ---> n >> 1
    }
}
