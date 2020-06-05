package com.xiong.LeetCode.JianZhiOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/1 20:23
 * @description： 面试题58 - II. 左旋转字符串
 * @modified By：
 * @version: $
 */
public class J58_reverseLeftWords_2 {

    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() <= 1){
            return s;
        }
        // 方法1
        // 前 n 位翻转  剩余的翻转
        // 然后整体翻转


        //针对字符串的我们有更简单的方法， 后半部分添加到前面 ，前半部分添加到后面
        StringBuilder ans = new StringBuilder();
        // 处理下n
        n = n % s.length();
        ans.append(s, n, s.length());
        ans.append(s, 0, n);
        return ans.toString();
    }
}
