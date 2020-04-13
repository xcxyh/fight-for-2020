package com.xiong.LeetCode.DailyProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/10 17:03
 * @description： 7. 整数反转
 * @modified By：
 * @version: $
 */
public class Leet7_reverseNum {
    public int reverse(int x) {
        if(x == 0){
            return 0;
        }

        int ans = 0;
        while(x != 0){
            int temp = x % 10;
            x /= 10;
            if(ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && temp < -8)){
                return 0;
            }
            if(ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && temp > 7)){
                return 0;
            }
            ans = ans * 10 + temp;
        }
        return ans;
    }
}
