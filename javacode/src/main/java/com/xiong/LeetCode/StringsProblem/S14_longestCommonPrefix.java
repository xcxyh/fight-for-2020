package com.xiong.LeetCode.StringsProblem;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/1 17:39
 * @description： 14. 最长公共前缀
 * @modified By：
 * @version: $
 */
public class S14_longestCommonPrefix {
    //我自己的实现
    public String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0){
            return "";
        }
        String prefix = strs[0]; //设一个为前缀
        for(String str : strs){
            int i = 0;
            while(i < Math.min(str.length(),prefix.length())
                    && prefix.charAt(i)== str.charAt(i)){ //不满足就截取
                i++;
            }
            prefix =prefix.substring(0,i);
        }
        return prefix;
    }
    //使用关键方法 startWith() 来判断 字符串是否以一个前缀开头，否则就从后截取 prefix
    public String longestCommonPrefix_dalao(String[] strs) {
        int count = strs.length;
        String prefix = "";
        if (count != 0) {
            prefix = strs[0];
        }
        for (int i = 0; i < count; i++) {
            //关键代码，不断的从后往前截取字符串，然后与之相比，直到startsWith()返回true
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

}
