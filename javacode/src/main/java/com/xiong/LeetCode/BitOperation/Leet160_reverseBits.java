package com.xiong.LeetCode.BitOperation;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/3/29 9:17
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet160_reverseBits {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;

        for (int i = 1; i <= 32; i++) {
            if (n == 0) {
                break;
            }

            res = res | ((n & 1) << (32 - i));

            n = n >> 1;
        }

        return res;
    }
}
