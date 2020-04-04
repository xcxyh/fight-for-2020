package com.xiong.LeetCode.DailyProblems;

import javax.xml.stream.events.Characters;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/3 11:16
 * @description： 8. 字符串转换整数 (atoi)
 * @modified By：
 * @version: $
 */
public class D8_myAtoi {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(myAtoi("20000000000000000"));
    }

    public static int myAtoi(String str) {
        if (str == null || str.length() == 0){
            return 0;
        }
        int i =0;
        //找到第一个非空字符
        while (i < str.length() && str.charAt(i) == ' '){
            i++;
        }
        //判断正负号 '+' == 43  '-' == 45
        int flag = '+' ;
        if(i < str.length() &&( str.charAt(i) == '-' || str.charAt(i) == '+')) {
            flag = str.charAt(i);
            i++;
        }
        // 单个字符 转 数字   Character.isDigit(c)
        int res = 0;
        while(i < str.length() && str.charAt(i) -'0' >=0 && str.charAt(i) -'9' <= 0){
            int temp = str.charAt(i) -'0';
            //判断是否溢出 Integer.MAX_VALUE = 2147483647
            if (res > Integer.MAX_VALUE /10 || res ==Integer.MAX_VALUE /10 && temp > 7  ){
                return flag == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + temp;
            i++;
        }

        return  flag == '-' ? -res : res;

    }
}
