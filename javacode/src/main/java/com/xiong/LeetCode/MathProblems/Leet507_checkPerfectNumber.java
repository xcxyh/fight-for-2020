package com.xiong.LeetCode.MathProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/2 10:12
 * @description： 507. 完美数
 * @modified By：
 * @version: $
 */
public class Leet507_checkPerfectNumber {

    public boolean checkPerfectNumber(int num) {

        if (num <= 1){
            return false;
        }
        //
        int ans = 1;
        int i = 2;
        while(i <= Math.sqrt(num)){
            if (num % i == 0){
                ans += i;
                ans += num / i;
            }
            i++;
        }

        return ans == num;
    }
}
