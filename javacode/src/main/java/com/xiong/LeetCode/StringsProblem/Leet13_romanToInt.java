package com.xiong.LeetCode.StringsProblem;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/7 12:25
 * @description： 13. 罗马数字转整数
 * @modified By：
 * @version: $
 */
public class Leet13_romanToInt {

    public int romanToInt(String s) {

        int n = s.length();
        int preNum = getValue(s.charAt(0));
        int sum = 0;
        for (int i = 1; i < n; i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num){
                sum -= preNum;
            }else{
                sum += preNum;
            }
            preNum = num;

        }

        sum += preNum;

        return sum;

    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
