package com.xiong.LeetCode.StringsProblem;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/24 14:02
 * @description： 459. 重复的子字符串
 * <p>
 * 包含循环节的字符串具有以下性质：
 * 1 如果 s 中没有循环节，那么 ss 中必然有且只有两个 s，此时从 s[1] 处开始寻找 s ，
 * 必然只能找到第二个，所以此时返回值为 s.length()。
 * <p>
 * 2 当 s 中有循环节时，设循环节为 r，其长度为 l，那么 s 中必然有 s.size()/l + 1 个 s。
 * @modified By：
 * @version: $
 */
public class Leet459_repeatedSubstringPattern {

    // 利用性质
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        // 从 s[1] 处寻找
        return (s + s).indexOf(s, 1) != s.length();

    }

    public boolean repeatedSubstringPattern2(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        int n = s.length();

        for (int i = 1; i < n / 2 + 1; i++) {
            if (n % i == 0) {
                boolean match = true;
                // 验证 以当前长度作为子串  是否满足
                for (int j = i; j < n; j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }

        return false;
    }
}
