package com.xiong.LeetCode.JianZhiOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/7 8:59
 * @description：
 * @modified By：
 * @version: $
 */
public class J05_replaceSpace {

    public String replaceSpace(String s) {

        char[] chars  = s.toCharArray();
        int len = chars.length;
        // 计算新 字符串的长度
        int newLen = len;
        for(char c : chars){
            if (c == ' '){
                newLen += 2;
            }
        }
        // 新建字符数组 存储
        char[] newChars = new char[newLen];

        int i = len - 1;
        int j = newLen - 1;
        // 将 原字符串中的 字符 按照规则 移动到  新字符串中
        while(i >= 0 && j >= 0){
            if (chars[i] != ' '){
                newChars[j--] = chars[i--];
            }else{
                newChars[j--] = '0';
                newChars[j--] = '2';
                newChars[j--] = '%';
                i--;
            }
        }
        // 转成 String 对象
        return new String(newChars);
    }


}
