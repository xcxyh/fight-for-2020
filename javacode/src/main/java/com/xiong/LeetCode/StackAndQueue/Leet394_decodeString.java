package com.xiong.LeetCode.StackAndQueue;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/28 12:04
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet394_decodeString {
    int cur = 0; // 全局

    public String decodeString(String s) {

        LinkedList<String> stack = new LinkedList<>();
        while (cur < s.length()) {
            char c = s.charAt(cur);

            if (Character.isDigit(c)) { // 得到 一个数 13 入栈
                String digit = getDigits(s);
                stack.addLast(digit);
            } else if (Character.isLetter(c) || c == '[') {
                stack.addLast(String.valueOf(s.charAt(cur++)));
            } else { // 遇到 ']'

                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stack.peekLast())) {
                    sub.addLast(stack.removeLast());
                }
                Collections.reverse(sub);
                stack.removeLast(); // 去掉 '['
                int repTime = Integer.parseInt(stack.removeLast());
                StringBuilder sb = new StringBuilder();
                while (repTime-- > 0) {
                    String subStr = getStr(sub);
                    sb.append(subStr);
                }
                // 拼接完后再次加入栈中
                stack.addLast(sb.toString());
                ++cur; // 后移一位
            }
        }
        return getStr(stack);
    }

    // 从 LinkedList 中 得到 拼接后的 字符串
    private String getStr(LinkedList<String> list) {
        StringBuilder sb = new StringBuilder();

        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }


    //从字符串中获取数字字符串  如  "13"
    private String getDigits(String s) {
        StringBuilder sb = new StringBuilder();

        while (cur < s.length() && Character.isDigit(s.charAt(cur))) {
            sb.append(s.charAt(cur++));
        }
        return sb.toString();
    }

}
