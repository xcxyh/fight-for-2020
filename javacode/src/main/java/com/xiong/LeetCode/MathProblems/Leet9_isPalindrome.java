package com.xiong.LeetCode.MathProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/10 17:02
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet9_isPalindrome {

    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        int oldX = x;
        int newX = 0;
        // 构建一个新数字 和 原来的相反
        while(x != 0){
            int low = x % 10;
            newX = newX * 10 + low;
            x /= 10;
            //System.out.print(newX + " ");
        }

        return oldX == newX;
    }
}
