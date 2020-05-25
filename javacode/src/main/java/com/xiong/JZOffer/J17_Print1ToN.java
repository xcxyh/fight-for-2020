package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/1/13 16:48
 * @description： 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
 * 由于 n 可能会非常大，因此不能直接用 int 表示数字，而是用 char 数组进行存储。
 *
 * 使用回溯法得到所有的数。
 *
 * 看不懂
 * @modified By：
 * @version: $
 */
public class J17_Print1ToN {
    public static void main(String[] args) {
        new J17_Print1ToN().print1ToMaxOfNDigits(3);
    }
    //主方法
    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, 0);

    }
    //复写主方法
    public void print1ToMaxOfNDigits(char[] number, int digit) {
            if(number.length == digit){
                printNumber(number);
                return;
            }
            //回溯找到所有的数字
        for (int i = 0; i <10 ; i++) {
            number[digit] = (char) (i + '0');
            print1ToMaxOfNDigits(number,digit + 1);

        }
    }
    //将字符数组中的数字打印出来【0000000123】
    public void printNumber(char[] num){
        int index = 0;
        // 一直后移到第一个不为0的元素
        while (index < num.length && num[index] == '0'){
            index++;
        }
        //从这个不为0 的元素开始打印
        while (index < num.length){
            System.out.print(num[index++]);
        }
        System.out.println();
    }
}
