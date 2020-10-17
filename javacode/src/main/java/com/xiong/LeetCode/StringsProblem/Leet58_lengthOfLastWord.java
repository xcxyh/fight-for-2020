package com.xiong.LeetCode.StringsProblem;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/9/22 11:14
 * @description： 58. 最后一个单词的长度
 * @modified By：
 * @version: $
 */
public class Leet58_lengthOfLastWord {


    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();

        int i = n - 1;

        while ( i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        int count = 0;
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                break;
            }
            count++;
            i--;
        }

        return count;
    }
}
