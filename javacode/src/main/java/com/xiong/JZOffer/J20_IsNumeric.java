package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/1 10:53
 * @description： 题目描述
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * <p>
 * 使用正则表达式进行匹配。
 * <p>
 * []  ： 字符集合
 * ()  ： 分组
 * ?   ： 重复 0 ~ 1 次
 * +   ： 重复 1 ~ n 次
 * *   ： 重复 0 ~ n 次
 * .   ： 任意字符
 * \\. ： 转义后的 .
 * \\d ： 数字
 * @modified By：
 * @version: $
 */
public class J20_IsNumeric {
    public static void main(String[] args) {
        System.out.println(isNumeric("3.15e+15"));
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");

    }
}
