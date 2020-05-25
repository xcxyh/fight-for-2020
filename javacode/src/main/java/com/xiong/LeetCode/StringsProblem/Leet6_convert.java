package com.xiong.LeetCode.StringsProblem;


/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/13 12:45
 * @description：  6. Z 字形变换
 * @modified By：
 * @version: $
 */
public class Leet6_convert {

    public static void main(String[] args) {
        System.out.println(new Leet6_convert().convert("LEETCODEISHIRING", 4));
    }

    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }

        StringBuilder[] sbs = new StringBuilder[numRows];
        char[] chars = s.toCharArray();
        //初始化
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }

        int k = 0;
        int flag = 0;
        int i = 0;
        while (k < chars.length) {

            if (flag == 0) {
                sbs[i++].append(chars[k]);
            } else {
                sbs[i--].append(chars[k]);
            }
            if (i == numRows - 1 || i == 0) {
                flag ^= 1;
            }
            k++;
        }

        StringBuilder ans = new StringBuilder();
        for (StringBuilder sb : sbs) {
            ans.append(sb);
        }

        return ans.toString();
    }
}
