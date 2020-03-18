package com.xiong.LeetCode.StringsProblem;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/17 10:51
 * @description： 将字符串向右循环移动 k 位。
 * <p>
 * 将 abcd123 中的 abcd 和 123 单独翻转，得到 dcba321，然后对整个字符串进行翻转，得到 123abcd。
 * @modified By：
 * @version: $
 */
public class S2_RightLoopMove {

    public static void main(String[] args) {
        System.out.println(new S2_RightLoopMove().rightLoopMove("abcd123", 3));

    }

    public String rightLoopMove(String str, int k) {
        char[] chars = str.toCharArray();
        int len = chars.length;
        reverseString(chars, 0, len - k - 1); //
        reverseString(chars, len - k, len - 1);
        reverseString(chars, 0, len - 1);

        StringBuilder stringBuilder = new StringBuilder();
        for (char c :chars) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    /**
     * @author: xiongcong
     * @Date: 2020/3/17 11:13
     * @Description: 翻转一个char数组中的部分元素
     */
    private static void reverseString(char[] chars, int left, int right) {
        if (chars.length <= 1) {
            return;
        }
        while (left < right) {
            //交换
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
