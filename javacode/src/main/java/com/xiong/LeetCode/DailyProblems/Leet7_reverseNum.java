package com.xiong.LeetCode.DailyProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/10 17:03
 * @description： 7. 整数反转
 * @modified By：
 * @version: $
 */
public class Leet7_reverseNum {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE); // 0x7fffffff;  2147483647
        System.out.println(Integer.MIN_VALUE); //  0x80000000;  -2147483648
    }
    public int reverse(int x) {
        int ans = 0;

        while (x != 0) {
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && x % 10 > 7) ) {
                return 0;
            }
            if(ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && x % 10 < -8)){
                return 0;
            }
            ans = ans * 10 + x % 10;

            x = x / 10;
        }

        return ans;
    }
}
