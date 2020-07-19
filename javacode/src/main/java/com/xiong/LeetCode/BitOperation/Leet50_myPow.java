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
    public double myPow_r(double x, int n) {
        int N = n;
        // n 为负 ，
        if (n < 0){
            // n 为 Integer.MIN_VALUE  的特殊情况
            if (n == Integer.MIN_VALUE){
                return 1 / x * myPow_r(1 / x, Integer.MAX_VALUE);
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
            return myPow_r(x, N - 1) * x;
        }
        // n 为 偶数
        return myPow_r( x*x , N / 2);
    }

}
