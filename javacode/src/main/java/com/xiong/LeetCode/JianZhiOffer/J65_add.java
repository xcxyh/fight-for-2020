package com.xiong.LeetCode.JianZhiOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/3 15:44
 * @description： 面试题65. 不用加减乘除做加法  位运算
 * @modified By：
 * @version: $
 */
public class J65_add {

    public int add(int a, int b) {
        // 非进位和  a^b
        // 进位和  c = (a & b) << 1
        // ans  =  a + b =  非进位和 + 进位和
        while (b != 0) { // 进位和  不为 0
            int c = (a & b) << 1;
            a = a ^ b;
            // 由于 不能使用 + 号 就将 b 给下一轮
            b = c;// 进位和 赋给 b
        }
        return a;
    }
}
