package com.xiong.LeetCode.StringsProblem;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/19 10:34
 * @description： 1071. 字符串的最大公因子 (对他们的长度 进行 辗转相除法)
 * 对于字符串 S 和 T，
 * 只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 * @modified By：
 * @version: $
 */
public class S1071_gcdOfStrings {
    /**
     *  @author: xiongcong
     *  @Date: 2020/3/19 10:42
     *  @Description: 别人写的
     */
    public String gcdOfStrings(String str1, String str2) {
        // 假设str1是N个x，str2是M个x，那么str1+str2肯定是等于str2+str1的。
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        // 辗转相除法求gcd。
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }
    // 辗转相除求 最大公因数
    private int gcd(int a, int b) {
        // 默认a >= b
        return b==0 ? a : gcd(b, a % b);
    }
    // 最小公倍数为两数的乘积除以最大公约数。
    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
