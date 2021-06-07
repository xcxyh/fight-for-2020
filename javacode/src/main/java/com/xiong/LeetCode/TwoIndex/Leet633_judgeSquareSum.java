package com.xiong.LeetCode.TwoIndex;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/4/28 11:05
 * @description：  633. 平方数之和    双指针
 * @modified By：
 * @version: $
 */
public class Leet633_judgeSquareSum {

    public boolean judgeSquareSum(int c) {

        int i = 0;
        int j = (int) Math.floor(Math.sqrt(c));

        while (i <= j) {

            if (i * i + j * j < c) {
                i++;
            }else if (i * i + j * j > c){
                j--;
            }else {
                return true;
            }
        }

        return false;
    }
}
