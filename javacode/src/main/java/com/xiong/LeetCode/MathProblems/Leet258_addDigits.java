package com.xiong.LeetCode.MathProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/9/8 16:09
 * @description： 258. 各位相加  树根问题
 * @modified By：
 * @version: $
 */
public class Leet258_addDigits {

    public int addDigits(int num) {

        return (num - 1) % 9 + 1;
    }

    public int addDigits1(int num) {
        if (num == 0) {
            return 0;
        }
        return num % 9 == 0 ? 9 : num % 9;
    }
}
