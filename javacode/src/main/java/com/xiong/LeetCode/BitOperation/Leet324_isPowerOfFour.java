package com.xiong.LeetCode.BitOperation;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/12 11:03
 * @description： 4的幂
 * @modified By：
 * @version: $
 */
public class Leet324_isPowerOfFour {

    public boolean isPowerOfFour(int num) {
        boolean isPowerOf2 = num > 0 && (num & (num - 1)) == 0;
        // 4 的 幂的 二进制中只有一个1， 且处于  0 2 4 6 ... 位上， 那么 & 上 10101010 必定为 0
        return isPowerOf2 && (num & 0xaaaaaaaa) == 0;
    }
}
