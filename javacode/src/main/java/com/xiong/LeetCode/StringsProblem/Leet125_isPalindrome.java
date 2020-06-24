package com.xiong.LeetCode.StringsProblem;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/19 10:04
 * @description： 125. 验证回文串
 * @modified By：
 * @version: $
 */
public class Leet125_isPalindrome {


    // 2020.06.19 每日一题
    public boolean isPalindrome(String s) {

        if (s == null || s.length() == 0){
            return true;
        }

        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while(left < right){
            while(left < right && ! Character.isLetterOrDigit(chars[left])){
                left++;
            }

            while(left < right && ! Character.isLetterOrDigit(chars[right])){
                right--;
            }

            if (left < right){
                if (istheSame(chars[left], chars[right])){
                    left++;
                    right--;
                }else{
                    return false;
                }
            }

        }
        return true;



    }

    private boolean istheSame(char a, char b){

        if (Character.isLetter(a) && Character.isLetter(b)){
            return Character.toLowerCase(a) == Character.toLowerCase(b);
        }
        // 有一个不是字母 就直接比较
        return a == b;
    }



    public boolean isPalindrome_1(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        int left = 0;
        int right = s.length() -1;
        while(left < right){//只考虑字母和数字字符
            while( left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while( left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if (left < right){
                if (! isthesame(s.charAt(left), s.charAt(right))){
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    private boolean isthesame(char a, char b){
        //忽略字母的大小写。
        if (Character.isLetter(a) && Character.isLetter(b)){
            return Character.toLowerCase(a) == Character.toLowerCase(b);
        }
        return a == b;

    }
}
