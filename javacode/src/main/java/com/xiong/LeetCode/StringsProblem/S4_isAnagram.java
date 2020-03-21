package com.xiong.LeetCode.StringsProblem;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/20 16:05
 * @description： 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * @modified By：
 * @version: $
 */
public class S4_isAnagram {
    /**
     * @author: xiongcong
     * @Date: 2020/3/20 16:05
     * @Description: 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 执行用时 :3 ms, 在所有 Java 提交中击败了92.72% 的用户
     */
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        char[] s_chars = s.toCharArray();
        for (char c : s_chars) {
            arr[c - 'a'] += 1;
        }
        boolean ret = true;
        char[] t_chars = t.toCharArray();
        for (char c : t_chars) {
            if (arr[c - 'a'] == 0) {
                ret = false;
                break;
            } else {
                arr[c - 'a']--;
            }
        }
        return ret;
    }

    /**
     *  @author: xiongcong
     *  @Date: 2020/3/20 16:12
     *  @Description: 官方解答
     */
    public boolean isAnagram_l(String s, String t) {
        int[] cnts = new int[26];
        for (char c : s.toCharArray()) {
            cnts[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            cnts[c - 'a']--;
        }
        for (int cnt : cnts) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }
}
