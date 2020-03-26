package com.xiong.LeetCode.StringsProblem;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/23 18:09
 * @description： 9. 回文数
 * @modified By：
 * @version: $
 */
public class S8_isPalindrome {

    public boolean isPalindrome(int x) {
        String s = x + "";
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
