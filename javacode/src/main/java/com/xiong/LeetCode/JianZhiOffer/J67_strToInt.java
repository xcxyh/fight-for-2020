package com.xiong.LeetCode.JianZhiOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/4 10:54
 * @description： 面试题67. 把字符串转换成整数
 * @modified By：
 * @version: $
 */
public class J67_strToInt {

    public int strToInt(String str) {

        int i = 0;
        int num = 0;
        int len = str.length();

        //处理空格
        while (i < len && str.charAt(i) == ' ') {
            i++;
        }
        //处理正负号 先处理正负号
        boolean isNegative = false;
        if (i < len && str.charAt(i) == '-') {
            isNegative = true;
            i++;
        } else if (i < len && str.charAt(i) == '+') {
            i++;
        }
        // 处理非数字
      /*  if (i < len && !Character.isDigit(str.charAt(i))) {
            return 0;
        }*/

        //处理数字
        while (i < len && Character.isDigit(str.charAt(i))) {
            int temp = str.charAt(i) - '0';
            //防止溢出  (这里忘记咋写了。。。)
            if (num > Integer.MAX_VALUE / 10 || num == Integer.MAX_VALUE / 10 && temp > 7) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            num = num * 10 + temp;
            i++;
        }
        return isNegative ? -num : num;

    }
}
