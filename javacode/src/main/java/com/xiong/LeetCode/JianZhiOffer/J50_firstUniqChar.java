package com.xiong.LeetCode.JianZhiOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/27 15:48
 * @description： 面试题50. 第一个只出现一次的字符
 * @modified By：
 * @version: $
 */
public class J50_firstUniqChar {

    public char firstUniqChar(String s) {
        int[] bucket = new int[26];
        //统计每个字符出现的个数
        for(char c : s.toCharArray()){
            bucket[c - 'a']++;
        }

        for(char c : s.toCharArray()){
            if (bucket[c - 'a'] == 1){
                return c;
            }
        }
        return ' ';
    }
}
