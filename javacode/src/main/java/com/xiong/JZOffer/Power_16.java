package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/1/13 16:04
 * @description： 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 *
 * 整个算法的时间复杂度为 O(logN)
 * @modified By：
 * @version: $
 */
public class Power_16 {
    public static void main(String[] args) {
        System.out.println(Power(4.0, 13));
    }

    private static double Power(double base, int exponent) {
        //基线条件1
        if(exponent == 0){
            return 1;
        }
        //基线条件2
        if (exponent == 1){
            return base;
        }

        boolean isfu = false;
        //指数为负
        if(exponent < 0){
            exponent = -exponent;
            isfu = true;
        }

        double pow = Power(base * base,exponent / 2);
        //指数为奇数时的情况
        if(exponent % 2 != 0){
            pow = pow * base;
        }
        //指数为负和正
        return isfu ? (1 / pow) : pow;
    }
}
