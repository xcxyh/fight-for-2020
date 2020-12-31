package com.xiong.LeetCode.HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/12/16 10:26
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet290_wordPattern {


    public boolean wordPattern(String pattern, String s) {
        if (pattern == null && s == null){
            return true;
        }
        if (pattern == null || s == null){
            return false;
        }

        Map<Character, String> map = new HashMap<>();

        String[] strs = s.split(" ");

        int len = pattern.length();

        if (strs.length != len){
            return false;
        }

        for(int i = 0;i < len; i++){
            char c = pattern.charAt(i);
            if (!map.containsKey(c)){
                // 这里判断下值 就不需要两个map 了， 例： abba ----> dog dog dog dog
                if (! map.containsValue(strs[i])){
                    map.put(c, strs[i]);
                }else{
                    return false;
                }

            }else{
                if (!map.get(c).equals(strs[i])){
                    return false;
                }
            }
        }
        return true;


    }
}
