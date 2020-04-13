package com.xiong.LeetCode.StringsProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/9 18:03
 * @description： 3. 无重复字符的最长子串 滑动窗口法
 * @modified By：
 * @version: $
 */
public class Leet3_lengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        if(s == null && s.length() == 0){
            return 0;
        }
        //滑动窗口
        Set<Character> window = new HashSet<>();
        int len = s.length();
        char[] chars = s.toCharArray();
        int i = 0;int j =0;
        int ans = 0;
        while(i < len && j < len ){
            if (! window.contains(chars[j])){
                window.add(chars[j++]);
                ans = Math.max(ans,j - i);
            }else{
                window.remove(chars[i++]);
            }
        }
        return ans;
    }
}
