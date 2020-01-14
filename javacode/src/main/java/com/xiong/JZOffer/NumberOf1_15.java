package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/1/3 13:06
 * @description： 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @modified By：
 * @version: $
 */
public class NumberOf1_15 {

    public static void main(String[] args) {

    }

    public int NumberOf1(int n) {

        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public int NumberOf1t(int n) {
        return Integer.bitCount(n);
    }


}

