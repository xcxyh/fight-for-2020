package com.xiong.LeetCode.StringsProblem;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/19 9:43
 * @description：  680. 验证回文字符串 Ⅱ
 * @modified By：
 * @version: $
 */
public class Leet680_validPalindrome {

    public boolean validPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            if (s.charAt(left) != s.charAt(right)){
                break;
            }
            left++;
            right--;
        }
        return left >= right || isPalind(s, left + 1, right) || isPalind(s, left, right -1);

    }
    //判断一个字符串是否是回文串
    private boolean isPalind(String s, int i, int j){
        while(i < j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
