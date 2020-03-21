package com.xiong.LeetCode.StringsProblem;

import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/19 10:11
 * @description：
 * @modified By：
 * @version: $
 */
public class S1160_countCharacters {

    /**
     *  @author: xiongcong
     *  @Date: 2020/3/19 10:23
     *  @Description:
     *  执行用时 :6 ms, 在所有 Java 提交中击败了89.17%的用户
     */
    public int countCharacters(String[] words, String chars) {
        int[] arr_char = new int[26];
        char[] chars1 = chars.toCharArray();
        for (char c : chars1) {
            arr_char[c - 'a'] += 1;
        }
        int ret = 0;
        for (int i = 0; i < words.length; i++) {
            String temp = words[i];
            int[] arr_copy = Arrays.copyOf(arr_char,arr_char.length); // 每次使用都要复制一次
            boolean flag = true;
            for (int j = 0; j < temp.length(); j++) {
                char c = temp.charAt(j);
                if (arr_copy[c - 'a'] == 0) {
                    flag = false;
                    break;
                } else { //一个字母不能用两次
                    arr_copy[c - 'a']--;
                }
            }
            if (flag) {
                ret += temp.length();
            }
        }
        return ret;
    }

}
