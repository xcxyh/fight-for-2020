package com.xiong.LeetCode.StringsProblem;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/19 9:56
 * @description： 409. 最长回文串
 * @modified By：
 * @version: $
 */
public class S409_longestPalindome {

    /**
     *  @author: xiongcong
     *  @Date: 2020/3/19 9:54
     *  @Description: 回文字符串 计算一组字符集合可以组成的回文字符串的最大长度
     *  执行用时 : 1 ms, 在所有 Java 提交中击败了100.00%的用户
     */
    public int longestPalindrome(String s) {
        int[] arr = new int[58]; //大写字母 + 小写字母个数
        char[] chars = s.toCharArray();
        for (char c : chars) {
            arr[c - 'A'] += 1;
        }
        int ret = 0;
        for (int x : arr) {
            ret += x % 2 == 0 ? x : x - 1;
        }
        return ret < s.length() ? ret + 1 : ret;
    }

}
