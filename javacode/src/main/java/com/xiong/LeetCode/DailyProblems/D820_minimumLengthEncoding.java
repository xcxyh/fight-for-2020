package com.xiong.LeetCode.DailyProblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/28 11:13
 * @description： 820. 单词的压缩编码
 * @modified By：
 * @version: $
 */
public class D820_minimumLengthEncoding {
    /**
     * @author: xiongcong
     * @Date: 2020/3/28 11:22
     * @Description: 输入: words = ["time", "me", "bell"]  10 +3 - 1(一个单词是另一个的后缀) - 2（后缀长度）
     * 输出: 10
     * 说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
     */


    public static void main(String[] args) {
        System.out.println(minimumLengthEncoding(new String[]{"atime", "aatime", "btime"}));
    }

    /**
     *  @author: xiongcong
     *  @Date: 2020/3/28 13:04
     *  @Description: 官方答案
     */
    public static int minimumLengthEncoding(String[] words) {
        //将 所有单词放到一个集合中
        Set<String> set = new HashSet<>(Arrays.asList(words));

        for (String word: words) {
            //遍历所有单词
            for (int i = 1; i <word.length() ; i++) {
                String temp = word.substring(i);
                set.remove(temp); //查看当前单词的所有后缀是否在集合中，是就删除
            }
        }
        int ans = 0;

        for (String str: set) {
            ans += str.length() + 1;
        }
        return ans;
    }
}
