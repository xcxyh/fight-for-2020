package com.xiong.LeetCode.JianZhiOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/10 17:38
 * @description： 面试题44. 数字序列中某一位的数字  这道数学题也太难了吧
 * @modified By：
 * @version: $
 */
public class J44_findNthDigit {

    public static void main(String[] args) {
        System.out.println(new J44_findNthDigit().findNthDigit(18));
    }

    public int findNthDigit(int n) {
        // 0   1
        // 1 --- 9  1 * 9
        // 10 --- 99  2 * 90
        // 100 --- 999  3 * 900
        //找到是几位数
        long i = 1, s = 9, base = 1;
        while (n > i * s) {
            n -= i * s; //  i * s  即 1 * 9  2 * 90  3 * 900 ......
            i++;
            s *= 10;
            base *= 10;
            //  System.out.print(i + " ");
        }

        // 此时 n
        //找到具体位于哪个数中
        // number 是所有的 i 位数中的 第 (n + i - 1) / i 个数
        long number = base - 1 + (n + i - 1) / i; // 10 + 5 - 1
        //找到number中的第几位
        // 如果除尽  则表明 为  最低位
        long r = n % i == 0 ? i : n % i;
        //否则 找到这一位
        for (int j = 0; j < i - r; j++) number /= 10;

        return (int) number % 10;


    }
}
