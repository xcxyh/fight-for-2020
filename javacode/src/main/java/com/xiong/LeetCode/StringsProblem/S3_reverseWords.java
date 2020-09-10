package com.xiong.LeetCode.StringsProblem;

import java.util.Stack;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/17 11:26
 * @description：
 * s = "I am a student"
 * Return "student a am I"
 *  将每个单词翻转，然后将整个字符串翻转。
 *  有两个版本：
 *  1  需要保留所有的空格
 *  2  不需要保留多余的空格 只保证单词间有一个空格
 *
 * @modified By：
 * @version: $
 */
public class S3_reverseWords {

    public static void main(String[] args) {
        System.out.println(reverseWords("  I   am     a       student   "));
    }





    /**
     *  @author: xiongcong
     *  @Date: 2020/3/17 11:50
     *  @Description: 可以有多个空格  "   I   am     a       student  "
     *   这个版本是保留所有的空格
     */
    public static String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        //单个单词翻转 再整体翻转
        char[] chars = s.toCharArray();
        int len = chars.length;
        int i = 0;
        int begin = 0;
        int j = 0;
        while(i < len){
            while(i < len && chars[i] == ' '){
                i++;
            }
            begin = i;
            while(i < len && chars[i] != ' '){
                i++;
            }
            reverse(chars,begin,i - 1);
            i++;
        }
        //整体翻转
        reverse(chars,0 , len - 1);
        return new String(chars);
    }

    private static void reverse(char[] chars, int start, int end){
        if (chars.length <= 1){
            return;
        }
        while(start < end){
            char c  = chars[start];
            chars[start] = chars[end];
            chars[end] = c;
            start++;
            end--;
        }
    }
    // 不包含空格的版本 返回   "students a am I"  去掉多余的空格

    public String reverseWords_nospaceStack(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder temp = new StringBuilder();
        s += " ";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (temp.length() != 0) {
                    stack.push(temp.toString());
                    temp = new StringBuilder();
                }
            } else {
                temp.append(s.charAt(i));
            }
        }
        if (stack.isEmpty()) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        res.append(stack.pop());
        while (!stack.isEmpty()) {
            res.append(" ");
            res.append(stack.pop());
        }
        return res.toString();
    }

    public String reverseWords_noSpace(String s) {
        StringBuilder sb = new StringBuilder();
        s= s.trim();
        String[] strs = s.split(" ");
        for (int i = 0; i <strs.length ; i++) {
            if(!strs[strs.length - i - 1].isEmpty()) {
                sb.append(strs[strs.length - i - 1]);
                if (i != strs.length - 1) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
}
