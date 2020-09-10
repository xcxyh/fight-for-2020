package com.xiong.LeetCode.StringsProblem;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/29 15:39
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet214_shortestPalindrome {


    // 找 s 的前缀 和 s的翻转 的后缀 相等时， 此时 将 r 的前缀加到 s 的前面 即可
    public String shortestPalindrome(String s) {

        String r = new StringBuilder(s).reverse().toString();

        int n = s.length();
        int i = 0;

        while(true){
            if (s.substring(0, n - i).equals(r.substring(i))){
                break;
            }
            i++;
        }

        return r.substring(0, i) + s;
    }
}
